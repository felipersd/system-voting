package com.br.systemvoting.service;

import com.br.systemvoting.domain.Session;
import com.br.systemvoting.domain.dto.session.request.SessionRequest;
import com.br.systemvoting.domain.dto.session.response.SessionResponse;
import com.br.systemvoting.job.CloseSession;
import com.br.systemvoting.repository.ScheduleRepository;
import com.br.systemvoting.repository.SessionRepository;
import com.br.systemvoting.validation.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@Service
@Validated
@AllArgsConstructor
@Slf4j
public class SessionService {

	private SessionRepository sessionRepository;

	private ScheduleRepository scheduleRepository;

	private TaskScheduler taskScheduler;

    private CloseSessionService closeSession;

	public SessionResponse insertSession(@Valid SessionRequest request) {
		var schedules = scheduleRepository.findAllById(request.getScheduleId());

		if (schedules.isEmpty()) {
			throw Message.NOT_FOUND_SCHEDULE.asBusinessException();
		}

		var session = Session.of(request, schedules);
		var sessionResponse = sessionRepository.save(session).toDto();
		sessionClosing(session);
		log.info("method = insertSession sessionId = {}", sessionResponse.getSessionId());
		return sessionResponse;
	}

	public List<SessionResponse> listAllSessions() {
		log.info("method = listSessions");
		List<Session> sessions = sessionRepository.findAll();
		List<Session> checkSessions = Session.checkListSessions(sessions);
		sessionRepository.saveAll(checkSessions);
		return checkSessions.stream().map(Session::toDto).collect(Collectors.toList());
	}

	public SessionResponse getSession(Long sessionId) {
		return sessionRepository.findById(sessionId).orElseThrow(Message.NOT_FOUND_SESSION::asBusinessException)
				.toDto();
	}

	private void sessionClosing(Session session) {
		Instant instant = calculateClosingTime(session.getDuration().intValue());
		taskScheduler.schedule(new CloseSession(session.getSessionId(), closeSession), instant);
	}

	private Instant calculateClosingTime(Integer duration) {
		return Instant.now().plusSeconds(duration * 60);
	}

}

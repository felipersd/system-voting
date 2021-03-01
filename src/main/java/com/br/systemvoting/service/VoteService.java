package com.br.systemvoting.service;

import com.br.systemvoting.domain.Schedule;
import com.br.systemvoting.domain.Vote;
import com.br.systemvoting.domain.dto.vote.request.VoteRequest;
import com.br.systemvoting.domain.dto.vote.response.VoteResponse;
import com.br.systemvoting.repository.AssociateRepository;
import com.br.systemvoting.repository.SessionRepository;
import com.br.systemvoting.repository.VoteRepository;
import com.br.systemvoting.validation.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import javax.validation.Valid;

@Service
@AllArgsConstructor
@Validated
@Slf4j
public class VoteService {

    private VoteRepository voteRepository;

    private AssociateRepository associateRepository;

    private SessionRepository sessionRepository;

    private UserInfoService userInfoService;

    public VoteResponse insertVote(@Valid VoteRequest request) {

        var session = sessionRepository.findById(request.getSessionId())
                .orElseThrow(Message.NOT_FOUND_SESSION::asBusinessException);

        if (!session.checkSchedule()) {
            sessionRepository.save(session);
            throw Message.BAD_REQUEST_SCHEDULE_CLOSED.asBusinessException();
        }

        Schedule schedule = session.getSchedules().stream()
                .filter(sc -> sc.getScheduleId().equals(request.getScheduleId())).findFirst()
                .orElseThrow(Message.NOT_FOUND_SCHEDULE_AT_SESSION::asBusinessException);

        var associate = associateRepository.findByCpf(request.getCpf())
                .orElseThrow(Message.NOT_FOUND_ASSOCIATE::asBusinessException);

        if (userInfoService.checkAssociateCanVote(request.getCpf())) {           
            List<Vote> list = voteRepository.findByAssociateAndSchedule(associate, schedule);
            if (list.isEmpty()) {
                var vote = voteRepository.save(Vote.of(request, associate, schedule));
                log.info("method = insertVote voteId = {}", vote.getVoteId());
            } else {
                throw Message.BAD_REQUEST_VOTE.asBusinessException();
            }
        } else {
            throw Message.BAD_REQUEST_VOTE.asBusinessException();
        }

        return new VoteResponse("Voto salvo com sucesso!");
    }

}

package com.br.systemvoting.feature;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.br.systemvoting.domain.Schedule;
import com.br.systemvoting.domain.Session;
import com.br.systemvoting.domain.dto.session.request.SessionRequest;
import com.br.systemvoting.domain.dto.session.response.SessionResponse;
import com.br.systemvoting.domain.enums.Status;

public class SessionScenarioFactory {

    public static final Session SESSION = loadSession();
    public static final Session SESSION_NEW = loadNewSession();
    public static final Session SESSION_BUILDER = loadSessionBuilder();
    public static final Session SESSION_SET = loadSessionSet();
    public static final Session SESSION_GET = loadSessionGet();
    public static final SessionResponse SESSION_RESPONSE = loadSessionResponse();
    public static final Session SESSION_OF = loadScheduleOf();
    public static final Long SESSION_ID = 1L;
    public static final Session SESSION_INSERT = loadSessionInsert();
    public static final SessionRequest SESSION_REQUEST = loadSessionRequest();
    public static final List<Schedule> SCHEDULE_LIST = loadScheduleList();
    public static final SessionResponse SESSION_RESPONSE_CONTROLLER = loadSessionResponseController();
    public static final List<SessionResponse> SESSION_RESPONSE_LIST = loadSessionResponseList();

    private static Session loadSession() {
        List<Schedule> list = new ArrayList<>();
        list.add(ScheduleScenarioFactory.SCHEDULE);
        return new Session(1L, LocalDateTime.now(), list, 5L, Status.OPEN);
    }

    private static Session loadNewSession() {
        List<Schedule> list = new ArrayList<>();
        list.add(ScheduleScenarioFactory.SCHEDULE_NEW);
        return new Session(1L, LocalDateTime.now(), list, 5L, Status.OPEN);
    }

    private static Session loadSessionBuilder() {
        List<Schedule> list = new ArrayList<>();
        list.add(ScheduleScenarioFactory.SCHEDULE);
        return Session.builder().sessionId(1L).meetingDate(LocalDateTime.now()).schedules(list).duration(3L)
                .status(Status.OPEN).build();
    }

    private static Session loadSessionSet() {
        List<Schedule> list = new ArrayList<>();
        list.add(ScheduleScenarioFactory.SCHEDULE);
        Session session = new Session();
        session.setSessionId(1L);
        session.setMeetingDate(LocalDateTime.now());
        session.setSchedules(list);
        session.setDuration(4L);
        session.setStatus(Status.OPEN);
        return session;
    }

    private static Session loadSessionGet() {
        Session session = new Session();
        session.getSessionId();
        session.getMeetingDate();
        session.getSchedules();
        session.getDuration();
        session.getStatus();
        return session;
    }

    private static SessionResponse loadSessionResponse() {
        Session session = loadSession();
        return session.toDto();
    }

    private static Session loadScheduleOf() {
        SessionRequest request = SessionRequest.builder().build();
        List<Schedule> list = new ArrayList<>();
        list.add(ScheduleScenarioFactory.SCHEDULE);
        return Session.of(request, list);
    }

    private static Session loadSessionInsert() {
        List<Schedule> list = new ArrayList<>();
        list.add(ScheduleScenarioFactory.SCHEDULE_SAVE);
        return new Session(1L, LocalDateTime.now(), list, 5L, Status.OPEN);
    }

    private static SessionRequest loadSessionRequest() {
        List<Long> ids = new ArrayList<>();
        ids.add(5L);
        return SessionRequest.builder().duration(1L).scheduleId(ids).build();
    }

    private static List<Schedule> loadScheduleList() {
        List<Schedule> schedules = new ArrayList<>();
        Schedule schedule2 = new Schedule(5L, "Teste", "Teste", null, null, 0, 0);
        schedules.add(schedule2);
        return schedules;
    }

    private static SessionResponse loadSessionResponseController() {
        Schedule schedule = new Schedule(1L, "Teste", "Teste", null, new ArrayList<>(), 0, 0);
        List<Schedule> list = new ArrayList<>();
        list.add(schedule);
        return new SessionResponse(1L, "2020-02-25T13:00:00", list, 1L, Status.OPEN);

    }

    private static List<SessionResponse> loadSessionResponseList() {
        return Arrays.asList(SESSION_RESPONSE_CONTROLLER);
    }

}

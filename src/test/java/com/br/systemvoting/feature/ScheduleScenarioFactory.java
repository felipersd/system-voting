package com.br.systemvoting.feature;

import java.util.ArrayList;
import java.util.List;

import com.br.systemvoting.domain.Schedule;
import com.br.systemvoting.domain.dto.schedule.request.ScheduleRequest;
import com.br.systemvoting.domain.dto.schedule.response.ScheduleResponse;

public class ScheduleScenarioFactory {
    
    public static final Schedule SCHEDULE = loadSchedule();
    public static final Schedule SCHEDULE_NEW = loadNewSchedule();
    public static final Schedule SCHEDULE_BUILDER = loadScheduleBuilder();
    public static final Schedule SCHEDULE_SET = loadScheduleSet();
    public static final Schedule SCHEDULE_GET = loadScheduleGet();
    public static final ScheduleResponse SCHEDULE_RESPONSE = loadScheduleResponse();
    public static final Schedule SCHEDULE_OF = loadScheduleOf();
    public static final ScheduleRequest SCHEDULE_REQUEST = loadScheduleRequest();
    public static final Schedule SCHEDULE_INSERT = loadScheduleInsert();
    public static final Schedule SCHEDULE_SAVE = loadScheduleSave();
    public static final List<ScheduleResponse> SCHEDULE_RESPONSES_LIST=loadScheduleResponseList();


    private static Schedule loadSchedule() {
        return new Schedule(1L, "Teste", "Teste", null, null, 0, 0);
    }

    private static Schedule loadNewSchedule() {
        return new Schedule(1L, "Teste2", "Teste2", null, null, 0, 0);
    }

    private static Schedule loadScheduleBuilder() {
        return Schedule.builder()
        .scheduleId(1L)
        .title("Teste")
        .subject("Teste")
        .session(null)
        .vote(null)
        .build();
    }

    private static Schedule loadScheduleSet() {
        Schedule schedule = new Schedule();
        schedule.setScheduleId(1L);
        schedule.setTitle("Teste");
        schedule.setSubject("Teste");
        schedule.setSession(null);
        schedule.setVote(null);
        return schedule;
    }

    private static Schedule loadScheduleGet() {
        Schedule schedule = new Schedule();
        schedule.getScheduleId();
        schedule.getTitle();
        schedule.getSubject();
        schedule.getSession();
        schedule.getVote();
        return schedule;
    }

    private static ScheduleResponse loadScheduleResponse() {
        Schedule schedule = loadSchedule();
        return schedule.toDto();        
    }

    private static Schedule loadScheduleOf() {
        ScheduleRequest request = ScheduleRequest.builder().title("Teste").subject("Teste").build();
        return Schedule.of(request);
    }

    private static ScheduleRequest loadScheduleRequest() {
        return ScheduleRequest.builder().title("Teste").subject("Teste").build();
    }

    public static List<Schedule> loadList() {
        List<Schedule> schedules = new ArrayList<>();
        Schedule schedule2 = new Schedule(5L, "Teste", "Teste", null , null, 0, 0);
        schedules.add(schedule2);
        return schedules;
    }

    private static Schedule loadScheduleInsert() {
        return new Schedule(1L, "Teste", "Teste", null , null, 0, 0);
    }

    private static Schedule loadScheduleSave() {
        return new Schedule(1L, "Teste", "Teste", SessionScenarioFactory.SESSION_INSERT , null, 0, 0);
    }

    private static List<ScheduleResponse> loadScheduleResponseList() {
        ArrayList<ScheduleResponse> list = new ArrayList<>();
        list.add(SCHEDULE_RESPONSE);
        return list;
    }

}

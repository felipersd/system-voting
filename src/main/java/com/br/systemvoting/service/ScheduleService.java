package com.br.systemvoting.service;

import com.br.systemvoting.domain.Schedule;
import com.br.systemvoting.domain.dto.schedule.request.ScheduleRequest;
import com.br.systemvoting.domain.dto.schedule.response.ScheduleResponse;
import com.br.systemvoting.repository.ScheduleRepository;
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
public class ScheduleService {

    private ScheduleRepository repository;

	public ScheduleResponse insertSchedule(@Valid ScheduleRequest request) {
        var schedule = repository.save(Schedule.of(request));
        log.info("method = insertSchedule scheduleId = {}", schedule.getScheduleId());
		return schedule.toDto();
	}
    
    public List<ScheduleResponse> listAllSchedules() {
        log.info("method = listAllSchedules");
        return Schedule.toList(repository.findAll());
    }
    
}

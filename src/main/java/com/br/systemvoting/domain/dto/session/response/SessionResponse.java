package com.br.systemvoting.domain.dto.session.response;

import com.br.systemvoting.domain.Schedule;
import com.br.systemvoting.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class SessionResponse {

    private Long sessionId;

    private String meetingDate;

    private List<Schedule> schedule;

    private Long duration;

    private Status status;
   
}

package com.br.systemvoting.domain.dto.schedule.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleResponse {
    
    private Long scheduleId;

    private String title;

    private String subject;
    
    private Integer totalAnswerYes;
    
    private Integer totalAnswerNo;

    public ScheduleResponse(Long scheduleId, String title, String subject) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.subject = subject;        
    }
    
}

package com.br.systemvoting.domain.dto.session.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
public class SessionRequest {
    
    private Long duration;

    @NotNull(message = "O campo scheduleId é obrigatório")
    @Size(message = "É preciso pelo menos um scheduleId", min = 1)
    private List<Long> scheduleId;
        
}

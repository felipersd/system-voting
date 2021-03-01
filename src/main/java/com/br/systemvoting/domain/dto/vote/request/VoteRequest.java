package com.br.systemvoting.domain.dto.vote.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;


@Getter
@Builder
public class VoteRequest {

    @NotNull(message = "O campo scheduleId é obrigatório")
    private Long scheduleId;

    @NotNull(message = "O campo sessionId é obrigatório")
    private Long sessionId;
    
    @NotNull(message = "O campo cpf é obrigatório")
    private String cpf;

    @NotNull(message = "O campo answer é obrigatório")
    private String answer;
    
}

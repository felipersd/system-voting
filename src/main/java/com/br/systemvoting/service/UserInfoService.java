package com.br.systemvoting.service;

import com.br.systemvoting.client.OpenFeignClient;
import com.br.systemvoting.client.StatusVote;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoService {

    private OpenFeignClient openFeign;

    public boolean checkAssociateCanVote(String cpf) {
        StatusVote canVote = openFeign.canVote(cpf);
        if(canVote.getStatus().equals("ABLE_TO_VOTE")) {
            return true;
        } else {
            return false;
        }
    }
    
}

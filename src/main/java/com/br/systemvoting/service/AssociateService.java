package com.br.systemvoting.service;

import com.br.systemvoting.domain.Associate;
import com.br.systemvoting.domain.dto.associate.request.AssociateRequest;
import com.br.systemvoting.domain.dto.associate.response.AssociateResponse;
import com.br.systemvoting.repository.AssociateRepository;
import com.br.systemvoting.validation.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@AllArgsConstructor
@Validated
@Slf4j
public class AssociateService {

    private AssociateRepository repository;

	public AssociateResponse insertAssociate(@Valid AssociateRequest request) {
        repository.findByCpf(request.getCpf()).ifPresent(a -> {throw Message.BAD_REQUEST_ASSOCIATE.asBusinessException();});
        
        var associate = repository.save(Associate.of(request));
        log.info("method = insertAssociate associateId = {}", associate.getAssociateId());
		return associate.toDto();
	}
    
}

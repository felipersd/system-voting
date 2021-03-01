package com.br.systemvoting.controller;

import com.br.systemvoting.annotation.InsertAssociatePostCodeStandard;
import com.br.systemvoting.domain.dto.associate.request.AssociateRequest;
import com.br.systemvoting.domain.dto.associate.response.AssociateResponse;
import com.br.systemvoting.service.AssociateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associates")
@Tag(name = "Associates")
@AllArgsConstructor
public class AssociateController {
    
    private AssociateService service;

    @PostMapping
    @InsertAssociatePostCodeStandard
    public ResponseEntity<AssociateResponse> insertAssociate(@RequestBody AssociateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertAssociate(request));
    }

}

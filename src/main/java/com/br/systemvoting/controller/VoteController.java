package com.br.systemvoting.controller;

import com.br.systemvoting.domain.dto.vote.request.VoteRequest;
import com.br.systemvoting.domain.dto.vote.response.VoteResponse;
import com.br.systemvoting.service.VoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votes")
@Tag(name = "Votes")
@AllArgsConstructor
public class VoteController {

    private VoteService service;

    @PostMapping
    public ResponseEntity<VoteResponse> insertVote(@RequestBody VoteRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.insertVote(request));
    }
    
}

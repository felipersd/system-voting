package com.br.systemvoting.controller;

import com.br.systemvoting.annotation.InsertSessionPostCodeStandard;
import com.br.systemvoting.annotation.ListScheduleGetCodeStandard;
import com.br.systemvoting.annotation.SessionGetCodeStandard;
import com.br.systemvoting.domain.dto.session.request.SessionRequest;
import com.br.systemvoting.domain.dto.session.response.SessionResponse;
import com.br.systemvoting.service.SessionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@Tag(name = "Sessions")
@AllArgsConstructor
public class SessionController {
    
    private SessionService service;

    @PostMapping
    @InsertSessionPostCodeStandard
    public ResponseEntity<SessionResponse> insertSession(@RequestBody SessionRequest request) {        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertSession(request));
    }

    @GetMapping("/listSessions")
    @ListScheduleGetCodeStandard
    public ResponseEntity<List<SessionResponse>> listAllSessions() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllSessions());
    }

    @GetMapping
    @SessionGetCodeStandard
    public ResponseEntity<SessionResponse> getSession(@RequestParam(required = true) Long sessionId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getSession(sessionId));
    }

}

package com.br.systemvoting.job;

import com.br.systemvoting.service.CloseSessionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CloseSession implements Runnable {

	private Long sessionId;

	private CloseSessionService service;

	@Override
	public void run() {
		log.info("method=close sessionId={}", sessionId);
		service.close(sessionId);
	}

}

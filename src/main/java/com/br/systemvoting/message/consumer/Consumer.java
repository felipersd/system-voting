package com.br.systemvoting.message.consumer;

import com.br.systemvoting.domain.Session;
import com.br.systemvoting.domain.dto.session.response.SessionResponse;
import com.br.systemvoting.repository.SessionRepository;
import com.br.systemvoting.validation.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @Autowired
    private SessionRepository sessionRepository;
    
    @RabbitListener(queues = "${ampq.rabbitmq.session.event.queueName}")
    public void receiveMessage(SessionResponse sessionResponse) throws Exception{
        Session session=sessionRepository.findById(sessionResponse.getSessionId()).orElseThrow(Message.NOT_FOUND_SESSION::asBusinessException);
        sessionRepository.save(session);
        log.info("method=receiveMessage sessionId={}",session.getSessionId());
    }
}


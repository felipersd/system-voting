package com.br.systemvoting.message.producer;

import com.br.systemvoting.domain.dto.session.response.SessionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class Producer {
    
    @Resource(name = "votingRabbitTemplate")
	private RabbitTemplate rabbitTemplate;

    public void publish(SessionResponse session,String queueName){
        rabbitTemplate.convertAndSend(queueName, session);
		log.info("method=publish queueName={}", queueName);
    }
}


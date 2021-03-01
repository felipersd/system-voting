package com.br.systemvoting.service;

import com.br.systemvoting.domain.Session;
import com.br.systemvoting.domain.enums.Status;
import com.br.systemvoting.message.producer.Producer;
import com.br.systemvoting.repository.SessionRepository;
import com.br.systemvoting.validation.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CloseSessionService {

    @Value("${ampq.rabbitmq.session.event.queueName}")
    private String queue;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private Producer producer;

    public void close(Long id) {
        Session response = sessionRepository.findById(id).orElseThrow(Message.NOT_FOUND_SESSION::asBusinessException);
        response.setStatus(Status.CLOSE);
        producer.publish(response.toDto(), queue);
    }
}

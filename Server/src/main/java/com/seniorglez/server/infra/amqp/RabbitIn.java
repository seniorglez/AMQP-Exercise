package com.seniorglez.server.infra.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitIn {

    @RabbitListener(queues = "server_in")
    public void processMessage(String content) {
        // ...
    }

}

package com.seniorglez.worker.infra.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitIn {

    @RabbitListener(queues = "worker_in")
    public void processMessage(String content) {
        // ...
    }

}

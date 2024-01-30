package com.seniorglez.server.infra.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;

@Component
public class RabbitOut {

    private final RabbitTemplate template;
    private final Queue queue;

    public RabbitOut(
            RabbitTemplate template,
            @Qualifier("workerIn") Queue queue
    ) {
        this.template = template;
        this.queue = queue;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(String msg) {
        this.template.convertAndSend(queue.getName(), msg);
        System.out.println(" [x] Sent '" + msg + "'");
    }

}

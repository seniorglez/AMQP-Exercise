package com.seniorglez.worker.infra.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RabbitOut {

    private final RabbitTemplate template;
    private final Queue queue;

    public RabbitOut(
            RabbitTemplate template,
            @Qualifier("serverIn") Queue queue
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

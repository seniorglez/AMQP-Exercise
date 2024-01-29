package com.seniorglez.worker.infra.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class RabbitQMConfiguration {

    @Bean
    public Queue hello() {
        return new Queue("worker_in");
    }


}
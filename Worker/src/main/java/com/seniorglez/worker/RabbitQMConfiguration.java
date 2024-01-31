package com.seniorglez.worker;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class RabbitQMConfiguration {

    @Bean
    public Queue workerIn() {
        return new Queue("worker_in");
    }

    @Bean
    public Queue serverIn() {
        return new Queue("server_in");
    }


}
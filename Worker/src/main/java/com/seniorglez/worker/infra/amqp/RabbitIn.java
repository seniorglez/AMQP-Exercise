package com.seniorglez.worker.infra.amqp;

import com.seniorglez.worker.application.useCase.ToMayusUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitIn {

    private final ToMayusUseCase toMayusUseCase;

    public RabbitIn(ToMayusUseCase toMayusUseCase) {
        this.toMayusUseCase = toMayusUseCase;
    }

    @RabbitListener(queues = "worker_in")
    public void processMessage(String content) {
        String mayus = toMayusUseCase.execute(content);
        System.out.println(mayus);
    }

}

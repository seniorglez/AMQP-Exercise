package com.seniorglez.worker.infra.amqp;

import com.seniorglez.worker.application.useCase.ToMayusUseCase;
import com.seniorglez.worker.domain.model.Task;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitIn {

    private final ToMayusUseCase toMayusUseCase;
    private final RabbitOut rabbitOut;

    public RabbitIn(
            ToMayusUseCase toMayusUseCase,
            RabbitOut rabbitOut
    ) {
        this.toMayusUseCase = toMayusUseCase;
        this.rabbitOut = rabbitOut;
    }

    @RabbitListener(queues = "worker_in")
    public void processMessage(String content) {
        String mayus = toMayusUseCase.execute(content);
        //TODO: FAKE proges...
        Task finalTask = new Task("id", true, 100, mayus);
        this.rabbitOut.send(finalTask.toJSON());
    }

}

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
        try {
            Thread.sleep(5000);
            this.rabbitOut.send(new Task("id", false, 20, null).toJSON());
            Thread.sleep(5000);
            this.rabbitOut.send(new Task("id", false, 50, null).toJSON());
            Thread.sleep(5000);
            this.rabbitOut.send(new Task("id", false, 70, null).toJSON());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //TODO: FAKE proges...
        Task finalTask = new Task("id", true, 100, mayus);
        this.rabbitOut.send(finalTask.toJSON());
    }

}

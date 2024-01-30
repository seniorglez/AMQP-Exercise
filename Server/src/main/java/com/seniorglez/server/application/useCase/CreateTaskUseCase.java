package com.seniorglez.server.application.useCase;

import com.seniorglez.server.application.annotation.Injectable;
import com.seniorglez.server.domain.model.Task;
import com.seniorglez.server.domain.port.WorkerService;

import java.util.UUID;

@Injectable
public class CreateTaskUseCase {

    private final WorkerService workerService;

    public CreateTaskUseCase(WorkerService workerService) {
        this.workerService = workerService;
    }

    public CreateTaskOutput execute(CreateTaskInput input) {
        Task task = new Task(
                UUID.randomUUID().toString(),
                false,
                0,
                null
        );
        workerService.sendTask(input.getText());
        return new CreateTaskOutput(task);
    }

}

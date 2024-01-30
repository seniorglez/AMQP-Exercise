package com.seniorglez.server.application.useCase;

import com.seniorglez.server.application.annotation.Injectable;
import com.seniorglez.server.domain.port.WorkerService;

@Injectable
public class CreateTaskUseCase {

    private final WorkerService workerService;

    public CreateTaskUseCase(WorkerService workerService) {
        this.workerService = workerService;
    }

    public CreateTaskOutput execute(CreateTaskInput input) {
        workerService.sendTask("");
        return new CreateTaskOutput();
    }


}

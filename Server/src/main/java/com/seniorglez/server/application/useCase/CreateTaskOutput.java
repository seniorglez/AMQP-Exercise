package com.seniorglez.server.application.useCase;

import com.seniorglez.server.domain.model.Task;
import com.seniorglez.server.infra.api.v1.view.task.TaskResponse;


public class CreateTaskOutput {

    private final Task task;

    public CreateTaskOutput(Task task) {
        this.task = task;
    }

    public TaskResponse toTaskResponse() {
        return new TaskResponse(
                task.id(),
                task.completed(),
                task.progress(),
                null
        );
    }
}

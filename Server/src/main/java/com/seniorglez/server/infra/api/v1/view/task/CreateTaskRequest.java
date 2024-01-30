package com.seniorglez.server.infra.api.v1.view.task;

import com.seniorglez.server.application.useCase.CreateTaskInput;

public class CreateTaskRequest {

    private String text;

    public String getText() {
        return text;
    }

    public CreateTaskInput toCreateTaskInput() {
        return new CreateTaskInput(text);
    }
}

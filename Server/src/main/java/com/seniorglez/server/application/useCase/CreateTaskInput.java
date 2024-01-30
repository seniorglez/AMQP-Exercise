package com.seniorglez.server.application.useCase;

public class CreateTaskInput {

    private final String text;

    public CreateTaskInput(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

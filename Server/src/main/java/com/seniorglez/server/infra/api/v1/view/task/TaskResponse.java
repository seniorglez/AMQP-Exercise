package com.seniorglez.server.infra.api.v1.view.task;

public class TaskResponse {

    private String response;

    public TaskResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}

package com.seniorglez.server.infra.api.v1.view.task;

public class TaskResponse {

    private final String id;
    private final Boolean completed;
    private final Integer progress;
    private final String result;

    public TaskResponse(String id, Boolean completed, Integer progress, String result) {
        this.id = id;
        this.completed = completed;
        this.progress = progress;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Integer getProgress() {
        return progress;
    }

    public String getResult() {
        return result;
    }
}

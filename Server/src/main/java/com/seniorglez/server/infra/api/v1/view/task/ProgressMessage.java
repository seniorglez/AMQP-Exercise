package com.seniorglez.server.infra.api.v1.view.task;

public class ProgressMessage {
    private final String id;
    private final Boolean completed;
    private final Integer progress;

    public ProgressMessage(String id, Boolean completed, Integer progress) {
        this.id = id;
        this.completed = completed;
        this.progress = progress;
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
}

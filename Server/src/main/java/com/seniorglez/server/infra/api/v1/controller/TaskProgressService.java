package com.seniorglez.server.infra.api.v1.controller;

import com.seniorglez.server.infra.api.v1.view.task.ProgressMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskProgressService {

    private final SimpMessagingTemplate messagingTemplate;

    public TaskProgressService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendProgressUpdate(Long taskId, ProgressMessage progress) {
        String destination = "/socket/progress/" + taskId;
        messagingTemplate.convertAndSend(destination, progress);
    }
}

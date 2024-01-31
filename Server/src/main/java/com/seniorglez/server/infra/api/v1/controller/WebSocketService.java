package com.seniorglez.server.infra.api.v1.controller;

import com.seniorglez.server.infra.api.v1.view.task.TaskResponse;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    final String URL = "/task";

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void send(TaskResponse taskResponse) {
        System.out.println("Send to client listening to: " + URL );
        messagingTemplate.convertAndSend(URL, taskResponse);
    }
}

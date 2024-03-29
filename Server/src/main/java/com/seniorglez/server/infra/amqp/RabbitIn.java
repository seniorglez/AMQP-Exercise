package com.seniorglez.server.infra.amqp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seniorglez.server.domain.model.Task;
import com.seniorglez.server.infra.api.v1.controller.WebSocketService;
import com.seniorglez.server.infra.api.v1.view.task.TaskResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitIn {

    private final WebSocketService webSocketService;

    public RabbitIn(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @RabbitListener(queues = "server_in")
    public void processMessage(String content) throws JsonProcessingException {
        System.out.println(content);
        ObjectMapper objectMapper = new ObjectMapper();
        Task task = null;
        task = objectMapper.readValue(content, Task.class);
        TaskResponse taskResponse = new TaskResponse(task.id(),task.completed(),task.progress(), task.result());
        webSocketService.send(taskResponse);
    }

}

package com.seniorglez.server.infra.api.v1.controller;

import com.seniorglez.server.infra.api.v1.view.task.ProgressMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskWebSocketController {

    @MessageMapping("/updateProgress/{taskId}")
    @SendTo("/socket/progress/{taskId}")
    public ProgressMessage updateProgress(@PathVariable Long taskId, ProgressMessage progress) {
        // Lógica para procesar el progreso y enviarlo a los clientes
        return progress;
    }
}

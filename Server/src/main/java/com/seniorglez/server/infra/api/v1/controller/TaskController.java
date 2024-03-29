package com.seniorglez.server.infra.api.v1.controller;


import com.seniorglez.server.application.useCase.CreateTaskInput;
import com.seniorglez.server.application.useCase.CreateTaskOutput;
import com.seniorglez.server.application.useCase.CreateTaskUseCase;
import com.seniorglez.server.infra.api.v1.view.task.CreateTaskRequest;
import com.seniorglez.server.infra.api.v1.view.task.TaskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
    }

    @PostMapping()
    private ResponseEntity<TaskResponse> createTask(@RequestBody CreateTaskRequest request) {
        CreateTaskOutput output = createTaskUseCase.execute(request.toCreateTaskInput());
        return new ResponseEntity<>( output.toTaskResponse(), HttpStatus.ACCEPTED);
    }

}

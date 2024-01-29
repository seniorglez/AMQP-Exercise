package com.seniorglez.server.infra.api.v1.controller;


import com.seniorglez.server.infra.api.v1.view.hello.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
public class HelloWorldController {

    @GetMapping()
    public HelloResponse hello() {
        return new HelloResponse("World");
    }

}

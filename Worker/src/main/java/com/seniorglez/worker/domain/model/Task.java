package com.seniorglez.worker.domain.model;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public record Task(
        String id,
        Boolean completed,
        Integer progress,
        String result) {

    public String toJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}



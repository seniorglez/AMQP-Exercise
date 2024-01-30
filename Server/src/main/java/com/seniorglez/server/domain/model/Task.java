package com.seniorglez.server.domain.model;



public record Task(
        String id,
        Boolean completed,
        Integer progress,
        String result) {
}

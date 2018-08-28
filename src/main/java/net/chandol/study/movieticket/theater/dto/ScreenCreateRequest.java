package net.chandol.study.movieticket.theater.dto;

import lombok.Data;

@Data
public class ScreenCreateRequest {
    private String name;

    public ScreenCreateRequest() {
    }

    public ScreenCreateRequest(String name) {
        this.name = name;
    }
}
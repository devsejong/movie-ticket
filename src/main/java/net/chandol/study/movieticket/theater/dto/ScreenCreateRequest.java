package net.chandol.study.movieticket.theater.dto;

import lombok.Data;

@Data
public class ScreenCreateRequest {
    private Long theaterId;
    private String name;

    public ScreenCreateRequest() {
    }

    public ScreenCreateRequest(Long theaterId, String name) {
        this.theaterId = theaterId;
        this.name = name;
    }
}
package net.chandol.study.movieticket.theater.dto;

import lombok.Data;

@Data
public class SeatCreateRequest {
    private Long screenId;
    private String row;
    private Integer column;

    public SeatCreateRequest() {
    }

    public SeatCreateRequest(Long screenId, String row, Integer column) {
        this.screenId = screenId;
        this.row = row;
        this.column = column;
    }
}
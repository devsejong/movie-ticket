package net.chandol.study.movieticket.theater.dto;

import lombok.Data;

@Data
public class SeatCreateRequest {
    private String row;
    private Integer column;

    public SeatCreateRequest() {
    }

    public SeatCreateRequest(String row, Integer column) {
        this.row = row;
        this.column = column;
    }
}
package net.chandol.study.movieticket.theater.dto;

import lombok.Data;

@Data
public class SeatCreateRequest {
    private Long screenId;
    private String row;
    private String column;
}
package net.chandol.study.movieticket.movie.dto;

import lombok.Data;

@Data
public class MovieCreateRequest {
    private String name;

    public MovieCreateRequest(String name) {
        this.name = name;
    }
}

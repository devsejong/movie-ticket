
package net.chandol.study.movieticket.theater.dto;

import lombok.Data;

@Data
public class TheaterCreateRequest{
        private String name;

    public TheaterCreateRequest(String name) {
        this.name = name;
    }
}
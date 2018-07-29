package net.chandol.study.movieticket.movie.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Movie(String name) {
        this.name = name;
    }
}

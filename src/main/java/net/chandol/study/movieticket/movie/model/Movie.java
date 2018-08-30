package net.chandol.study.movieticket.movie.model;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    protected Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }
}

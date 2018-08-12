package net.chandol.study.movieticket.showing.model;

import lombok.Getter;
import lombok.ToString;
import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.theater.model.Screen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@ToString
@Entity
public class Showing {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    private LocalDateTime showingAt;

    public Showing() {
    }

    public Showing(Movie movie, Screen screen, LocalDateTime showingAt) {
        this.movie = movie;
        this.screen = screen;
        this.showingAt = showingAt;
    }
}

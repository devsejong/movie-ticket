package net.chandol.study.movieticket.showing.model;

import lombok.Getter;
import lombok.ToString;
import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.theater.model.Screen;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "showing")
    private List<ShowingSeat> showingSeats = new ArrayList<>();
    private LocalDateTime showingAt;

    protected Showing() {
    }

    public Showing(Movie movie, Screen screen, LocalDateTime showingAt) {
        this.movie = movie;
        this.screen = screen;
        this.showingAt = showingAt;
    }

    void addShowingSeat(ShowingSeat showingSeat) {
        if (!showingSeats.contains(showingSeat)) {
            showingSeats.add(showingSeat);
        }
    }
}

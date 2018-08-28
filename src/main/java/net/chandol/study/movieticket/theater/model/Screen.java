package net.chandol.study.movieticket.theater.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Screen {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats = new ArrayList<>();

    public Screen(Theater theater, String name) {
        setTheater(theater);
        this.name = name;
    }

    private void setTheater(Theater theater) {
        this.theater = theater;
        theater.addScreen(this);
    }

    void addSeat(Seat seat) {
        if (!seats.contains(seat)) {
            seats.add(seat);
        }
    }
}

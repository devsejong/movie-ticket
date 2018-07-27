package net.chandol.study.movieticket.theater.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Seat {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Screen screen;

    private String row;

    private Integer column;

    public Seat(Screen screen, String row, Integer column) {
        setScreen(screen);
        this.row = row;
        this.column = column;
    }


    private void setScreen(Screen screen) {
        this.screen = screen;
        screen.addSeat(this);
    }
}

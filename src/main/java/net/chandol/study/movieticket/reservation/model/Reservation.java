package net.chandol.study.movieticket.reservation.model;

import lombok.Getter;
import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.model.ShowingSeat;
import net.chandol.study.movieticket.user.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// 예약 도메인
@Getter
@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @ManyToOne
    private User user;

    @ManyToOne
    private Showing showing;

    @OneToMany
    @JoinTable(name="RESERVATION_SHOWING_SEAT",
            joinColumns = @JoinColumn(name="RESERVATION_ID"),
            inverseJoinColumns = @JoinColumn(name="SHOWING_SEAT_ID"))
    private List<ShowingSeat> showingSeats = new ArrayList<>();
}

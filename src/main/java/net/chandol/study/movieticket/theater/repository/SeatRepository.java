package net.chandol.study.movieticket.theater.repository;

import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}

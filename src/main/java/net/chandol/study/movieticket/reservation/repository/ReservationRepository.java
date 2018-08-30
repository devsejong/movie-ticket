package net.chandol.study.movieticket.reservation.repository;

import net.chandol.study.movieticket.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

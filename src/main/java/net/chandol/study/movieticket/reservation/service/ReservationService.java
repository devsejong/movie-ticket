package net.chandol.study.movieticket.reservation.service;

import net.chandol.study.movieticket.reservation.model.Reservation;
import net.chandol.study.movieticket.reservation.repository.ReservationRepository;
import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.model.ShowingSeat;
import net.chandol.study.movieticket.showing.model.ShowingSeatStatus;
import net.chandol.study.movieticket.showing.service.ShowingSeatService;
import net.chandol.study.movieticket.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {
    @Autowired ShowingSeatService showingSeatService;
    @Autowired ReservationRepository reservationRepository;

    @Transactional
    public Reservation createWaitingReservation(User user, Showing showing, List<ShowingSeat> seats) {
        Reservation reservation = new Reservation(user, showing, seats);
        reservationRepository.save(reservation);

        for (ShowingSeat seat : seats) {
            seat.setUserAndStatus(user, ShowingSeatStatus.RESERVATION_WAITING);
        }

        return reservation;
    }
}

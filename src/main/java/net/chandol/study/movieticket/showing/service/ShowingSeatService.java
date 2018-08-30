package net.chandol.study.movieticket.showing.service;

import net.chandol.study.movieticket.common.exception.WorkInProgressException;
import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.model.ShowingSeat;
import net.chandol.study.movieticket.showing.repository.ShowingSeatRepository;
import net.chandol.study.movieticket.theater.model.Seat;
import net.chandol.study.movieticket.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static net.chandol.study.movieticket.showing.model.ShowingSeatStatus.RESERVATION_WAITING;

@Service
public class ShowingSeatService {
    @Autowired
    ShowingSeatRepository showingSeatRepository;

    @Transactional
    public List<ShowingSeat> occupyShowingSeats(List<ShowingSeat> seats, User user) {
        seats.forEach(seat -> {
            seat.setUserAndStatus(user, RESERVATION_WAITING);
        });
        throw new WorkInProgressException();
    }

    @Transactional
    public List<ShowingSeat> findShowingSeats(Showing showing, List<Seat> seats) {
        return showingSeatRepository.findShowingSeat(showing, seats);
    }
}

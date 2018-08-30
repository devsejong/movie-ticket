package net.chandol.study.movieticket.showing.service;

import net.chandol.study.movieticket.common.exception.WorkInProgressException;
import net.chandol.study.movieticket.showing.model.ShowingSeat;
import net.chandol.study.movieticket.showing.model.ShowingSeatStatus;
import net.chandol.study.movieticket.showing.repository.ShowingSeatRepository;
import net.chandol.study.movieticket.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShowingSeatService {
    @Autowired ShowingSeatRepository showingSeatRepository;

    @Transactional
    public List<ShowingSeat> choiceShowingSeats(List<ShowingSeat> seats, User user) {
        seats.stream().forEach(seat->{
            seat.setUserAndStatus(user, ShowingSeatStatus.PAYMENT_WAITING);
        });
        throw new WorkInProgressException();
    }
}

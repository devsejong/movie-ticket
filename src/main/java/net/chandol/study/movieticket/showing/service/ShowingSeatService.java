package net.chandol.study.movieticket.showing.service;

import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.model.ShowingSeat;
import net.chandol.study.movieticket.theater.model.Seat;
import net.chandol.study.movieticket.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShowingSeatService {
    @Autowired
    ShowingSeat showingSeat;

    @Transactional
    public List<ShowingSeat> selectShowingSeats(Showing showing, User user, List<Seat> seats) {

        return null;
    }
}

package net.chandol.study.movieticket.theater.service;

import net.chandol.study.movieticket.theater.dto.ScreenCreateRequest;
import net.chandol.study.movieticket.theater.dto.SeatCreateRequest;
import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.model.Seat;
import net.chandol.study.movieticket.theater.model.Theater;
import net.chandol.study.movieticket.theater.repository.ScreenRepository;
import net.chandol.study.movieticket.theater.repository.SeatRepository;
import net.chandol.study.movieticket.theater.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private TheaterRepository theaterRepository;

    @Transactional
    public Screen createScreen(ScreenCreateRequest createRequest) {
        Theater theater = theaterRepository.getOne(createRequest.getTheaterId());
        Screen screen = new Screen(createRequest.getName(), theater);

        return screenRepository.save(screen);
    }
}

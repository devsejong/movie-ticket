package net.chandol.study.movieticket.theater.service;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ScreenService {
    ScreenRepository screenRepository;
    TheaterRepository theaterRepository;

    @Transactional
    public Screen createScreen(ScreenCreateRequest createRequest) {
        Theater theater = theaterRepository.getOne(createRequest.getTheaterId());
        Screen screen = new Screen(createRequest.getName(), theater);

        return screenRepository.save(screen);
    }

    @Transactional(readOnly = true)
    public Screen getScreen(Long screenId){
        return screenRepository.getOne(screenId);
    }

}

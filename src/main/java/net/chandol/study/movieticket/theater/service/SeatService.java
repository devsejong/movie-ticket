package net.chandol.study.movieticket.theater.service;

import net.chandol.study.movieticket.theater.dto.SeatCreateRequest;
import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.model.Seat;
import net.chandol.study.movieticket.theater.repository.ScreenRepository;
import net.chandol.study.movieticket.theater.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeatService {
    private ScreenRepository screenRepository;
    private SeatRepository seatRepository;


    @Transactional
    public Seat createSeat(SeatCreateRequest request){
        Screen screen = screenRepository.getOne(request.getScreenId());
        Seat seat = new Seat(screen, request.getRow(), request.getColumn());

        return seatRepository.save(seat);
    }
}

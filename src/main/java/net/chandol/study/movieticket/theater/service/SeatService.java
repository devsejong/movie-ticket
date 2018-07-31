package net.chandol.study.movieticket.theater.service;

import lombok.AllArgsConstructor;
import net.chandol.study.movieticket.theater.dto.SeatCreateRequest;
import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.model.Seat;
import net.chandol.study.movieticket.theater.repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {
    SeatRepository seatRepository;

    @Transactional
    public Seat createSeat(Screen screen, SeatCreateRequest request) {
        Seat seat = new Seat(screen, request.getRow(), request.getColumn());

        return seatRepository.save(seat);
    }


    @Transactional(readOnly = true)
    public List<Seat> findByScreen(Screen screen) {
        return seatRepository.findByScreen(screen);
    }
}

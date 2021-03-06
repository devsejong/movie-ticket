package net.chandol.study.movieticket.theater.service;

import net.chandol.study.movieticket.theater.dto.ScreenCreateRequest;
import net.chandol.study.movieticket.theater.dto.SeatCreateRequest;
import net.chandol.study.movieticket.theater.dto.TheaterCreateRequest;
import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.model.Seat;
import net.chandol.study.movieticket.theater.model.Theater;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SeatServiceTest {

    @Autowired
    TheaterService theaterService;
    @Autowired
    ScreenService screenService;
    @Autowired
    SeatService seatService;

    @Test
    @Transactional
    public void createSeat() {
        // given
        Theater theater = theaterService.createTheater(new TheaterCreateRequest("대한극장"));
        Screen screen = screenService.createScreen(new ScreenCreateRequest(theater.getId(), "1관"));

        List<SeatCreateRequest> requests = asList(
                new SeatCreateRequest(screen.getId(), "A", 1),
                new SeatCreateRequest(screen.getId(), "A", 2),
                new SeatCreateRequest(screen.getId(), "B", 1),
                new SeatCreateRequest(screen.getId(), "B", 2)
        );

        // when
        for(SeatCreateRequest request : requests){
            seatService.createSeat(request);
        }

        // then
        List<Seat> createdSeats = seatService.findByScreen(screen);
        Assertions.assertThat(createdSeats).hasSize(4);
    }

}
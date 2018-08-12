package net.chandol.study.movieticket.theater.testutil;

import lombok.AllArgsConstructor;
import net.chandol.study.movieticket.theater.dto.ScreenCreateRequest;
import net.chandol.study.movieticket.theater.dto.SeatCreateRequest;
import net.chandol.study.movieticket.theater.dto.TheaterCreateRequest;
import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.model.Seat;
import net.chandol.study.movieticket.theater.model.Theater;
import net.chandol.study.movieticket.theater.service.ScreenService;
import net.chandol.study.movieticket.theater.service.SeatService;
import net.chandol.study.movieticket.theater.service.TheaterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Service
@AllArgsConstructor
public class TheaterTestDataGenerator {
    TheaterService theaterService;
    ScreenService screenService;
    SeatService seatService;

    @Transactional
    public List<Theater> createTestTheaters() {
        List<TheaterCreateRequest> requests = Arrays.asList(
                new TheaterCreateRequest("대한극장"),
                new TheaterCreateRequest("롯데시네마(포도몰)")
        );

        List<Theater> theaters = requests.stream()
                .map(theaterService::createTheater)
                .collect(Collectors.toList());

        return theaters;
    }

    @Transactional
    public List<Screen> createTestScreens(Theater theater) {
        List<ScreenCreateRequest> requests = Arrays.asList(
                new ScreenCreateRequest("1관"),
                new ScreenCreateRequest("2관")
        );

        List<Screen> screens = requests.stream()
                .map(s -> screenService.createScreen(theater, s))
                .collect(Collectors.toList());

        return screens;
    }

    @Transactional
    public List<Seat> createTestSeats(Screen screen) {
        List<SeatCreateRequest> requests = asList(
                new SeatCreateRequest("A", 1),
                new SeatCreateRequest("A", 2),
                new SeatCreateRequest("B", 1),
                new SeatCreateRequest("B", 2)
        );

        List<Seat> seats = requests.stream()
                .map(s -> seatService.createSeat(screen, s))
                .collect(Collectors.toList());

        return seats;
    }

    @Transactional
    public List<Theater> createTestAllData() {
        List<Theater> theaters = createTestTheaters();

        List<Screen> screens = theaters.stream()
                .map(this::createTestScreens)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        screens.forEach(this::createTestSeats);

        return theaters;
    }
}

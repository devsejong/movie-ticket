package net.chandol.study.movieticket.showing.testutil;

import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.showing.dto.ShowingCreateRequest;
import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.service.ShowingService;
import net.chandol.study.movieticket.theater.model.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ShowingTestDataGenerator {
    @Autowired
    ShowingService showingService;

    @Transactional
    public List<Showing> createTestShowings(Movie movie, Screen screen) {


        LocalDate today = LocalDate.now();
        return Arrays.asList(
                showingService.createShowing(movie, screen,new ShowingCreateRequest(today.atTime(10, 0))),
                showingService.createShowing(movie, screen,new ShowingCreateRequest(today.atTime(14, 0)))
        );
    }
}

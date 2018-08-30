package net.chandol.study.movieticket.showing.service;

import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.movie.testutil.MovieTestDataUtil;
import net.chandol.study.movieticket.showing.dto.ShowingCreateRequest;
import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.model.Theater;
import net.chandol.study.movieticket.theater.testutil.TheaterTestDataUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ShowingServiceTest {
    @Autowired
    TheaterTestDataUtil theaterTestDataUtil;
    @Autowired
    MovieTestDataUtil movieTestDataUtil;
    @Autowired
    ShowingService showingService;

    @Test
    public void createShowing() {
        // before
        List<Theater> testAllData = theaterTestDataUtil.createTheaterAllData();
        List<Screen> screens = testAllData.stream().map(Theater::getScreens)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<Movie> movies = movieTestDataUtil.createMovies();

        // given
        LocalDateTime showingAt = LocalDateTime.parse("2018-08-12T10:35:00");
        ShowingCreateRequest request = new ShowingCreateRequest(showingAt);

        // when
        Showing showing = showingService.createShowing(movies.get(0), screens.get(0), request);

        // then
        Showing resultShowing = showingService.getShowing(showing.getId());
        assertThat(resultShowing.getShowingAt(), is(showingAt));
    }
}
package net.chandol.study.movieticket.reservation;

import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.movie.testutil.MovieTestDataUtil;
import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.model.ShowingSeat;
import net.chandol.study.movieticket.showing.model.ShowingSeatStatus;
import net.chandol.study.movieticket.showing.service.ShowingService;
import net.chandol.study.movieticket.showing.testutil.ShowingTestDataUtil;
import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.testutil.TheaterTestDataUtil;
import net.chandol.study.movieticket.user.model.User;
import net.chandol.study.movieticket.user.testutil.UserTestDataUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationTest {
    @Autowired TheaterTestDataUtil theaterTestDataUtil;
    @Autowired UserTestDataUtil userTestDataUtil;
    @Autowired MovieTestDataUtil movieTestDataUtil;
    @Autowired ShowingTestDataUtil showingTestDataUtil;
    @Autowired ShowingService showingService;

    @Before
    public void setup() {
        // before:: 영화관, 스크린, 좌석이 만들어져 있어야 한다.
        theaterTestDataUtil.createTheaterAllData();

        // before:: 영화가 만들어져 있어야 하고
        movieTestDataUtil.createMovies();

        // before:: 그리고 사용자도 만들어져 있어야 함
        userTestDataUtil.createUsers();

        // before:: 상영이 만들어져 있어야 함
        List<Screen> screens = theaterTestDataUtil.getTheaterByName("대한극장").getScreens();
        Movie movie = movieTestDataUtil.getMovieByName("인셉션");
        showingTestDataUtil.createTestShowings(movie, screens);
    }

    @Test
    public void 사용자는_영화를_예매할수_있다() {
        // given
        User user = userTestDataUtil.getUserByUsername("gamja");
        Movie movie = movieTestDataUtil.getMovieByName("인셉션");

        // when
        // when:: 영화를 기준으로 영화를 찾은다음
        Page<Showing> showingPage = showingService.findShowingByMovie(movie);
        // when:: 첫번째 영화를 선택합니다.
        Showing showing = showingPage.getContent().get(0);

        // 2자리를 선택한다음
        List<ShowingSeat> availableShowingSeat = showing.getShowingSeats().stream().filter(s->s.getStatus() == ShowingSeatStatus.EMPTY).collect(Collectors.toList());
        List<ShowingSeat> selectedShowingSeat = availableShowingSeat.subList(0, 1);

        // 자리를 점유(?)한다


        // then
    }
}

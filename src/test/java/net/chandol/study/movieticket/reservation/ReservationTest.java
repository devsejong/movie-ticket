package net.chandol.study.movieticket.reservation;

import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.movie.testutil.MovieTestDataGenerator;
import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.testutil.ShowingTestDataGenerator;
import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.model.Theater;
import net.chandol.study.movieticket.theater.testutil.TheaterTestDataGenerator;
import net.chandol.study.movieticket.user.model.User;
import net.chandol.study.movieticket.user.testutil.UserTestDataGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationTest {
    @Autowired TheaterTestDataGenerator theaterTestDataGenerator;
    @Autowired UserTestDataGenerator userTestDataGenerator;
    @Autowired MovieTestDataGenerator movieTestDataGenerator;
    @Autowired ShowingTestDataGenerator showingTestDataGenerator;

    @Test
    public void 사용자는_영화를_예매할수_있다() {
        // before

        // before:: 영화관, 스크린, 좌석이 만들어져 있어야 한다.
        List<Theater> theaters = theaterTestDataGenerator.createTestAllData();

        // before:: 영화가 만들어져 있어야 하고
        List<Movie> movies = movieTestDataGenerator.createMovies();

        // before:: 그리고 사용자도 만들어져 있어야 함
        List<User> users = userTestDataGenerator.createUsers();

        // before:: 상영이 만들어져 있어야 함
        List<Screen> screens = theaters.stream()
                .map(Theater::getScreens)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        List<Showing> showings = new ArrayList<>();
        for (Screen screen : screens) {
            for (Movie movie : movies) {
                showings.addAll(showingTestDataGenerator.createTestShowings(movie, screen));
            }
        }

        // given

        // when

        // 유저가 날짜와 영화관을 선택하여 영화를 찾고
        User user = users.get(0);

        // 2자리를 선택한다음

        // 결제한다.

        // then
    }
}

package net.chandol.study.movieticket.reservation;

import net.chandol.study.movieticket.movie.testutil.MovieTestDataGenerator;
import net.chandol.study.movieticket.theater.testutil.TheaterTestDataGenerator;
import net.chandol.study.movieticket.user.testutil.UserTestDataGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationTest {
    @Autowired TheaterTestDataGenerator theaterTestDataGenerator;
    @Autowired UserTestDataGenerator userTestDataGenerator;
    @Autowired MovieTestDataGenerator movieTestDataGenerator;

    @Before
    public void initData() {
        // 영화관, 스크린, 좌석이 만들어져 있어야 한다.
        theaterTestDataGenerator.createTestAllDatas();

        // 영화가 만들어져 있어야 하고
        movieTestDataGenerator.createMovies();

        // 상영이 만들어져 있어야 함

        // 그리고 사용자도 만들어져 있어야 함
        userTestDataGenerator.createUsers();
    }

    @Test
    public void 사용자는_영화를_예매할수_있다() {

    }
}

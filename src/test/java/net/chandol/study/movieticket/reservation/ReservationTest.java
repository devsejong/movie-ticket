package net.chandol.study.movieticket.reservation;

import net.chandol.study.movieticket.theater.service.TheaterService;
import net.chandol.study.movieticket.theater.testutil.TheaterTestDataGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationTest {
    @Autowired
    TheaterTestDataGenerator theaterTestDataGenerator;

    @Before
    public void initData() {
        // 영화관, 스크린, 좌석이 만들어져 있어야 한다.
        // 영화가 만들어져 있어야 하고
        // 상영이 만들어져 있어야 함
        theaterTestDataGenerator.createTestAllData();

        // 그리고 사용자도 만들어져 있어야 함

    }

    @Test
    public void test1234(){

    }
}

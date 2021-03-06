package net.chandol.study.movieticket.theater.service;

import net.chandol.study.movieticket.theater.dto.ScreenCreateRequest;
import net.chandol.study.movieticket.theater.dto.TheaterCreateRequest;
import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.model.Theater;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.assertj.core.api.HamcrestCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Predicate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScreenServiceTest {

    @Autowired
    TheaterService theaterService;
    @Autowired
    ScreenService screenService;

    @Test
    @Transactional
    public void createScreen() {
        // given
        Theater theater = theaterService.createTheater(new TheaterCreateRequest("대한극장"));
        ScreenCreateRequest createRequest = new ScreenCreateRequest(theater.getId(), "1관");

        // when
        Screen screen = screenService.createScreen(createRequest);

        // then
        Screen retrevedScreen = screenService.getScreen(screen.getId());
        Assertions.assertThat(retrevedScreen)
                .hasFieldOrPropertyWithValue("name", "1관");
    }
}
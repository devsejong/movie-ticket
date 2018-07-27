package net.chandol.study.movieticket.theater.service;

import net.chandol.study.movieticket.theater.dto.TheaterCreateRequest;
import net.chandol.study.movieticket.theater.model.Theater;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TheaterServiceTest {

    @Autowired
    TheaterService theaterService;

    @Test
    public void createTheater() {
        // given
        TheaterCreateRequest createRequest = new TheaterCreateRequest("대한극장");

        // when
        Theater theater = theaterService.createTheater(createRequest);

        // then
        Assertions.assertThat(theater.getName()).isEqualTo("대한극장");
        Assertions.assertThat(theater.getId()).isNotNull();
    }
}
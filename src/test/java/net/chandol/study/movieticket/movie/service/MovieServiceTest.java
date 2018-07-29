package net.chandol.study.movieticket.movie.service;

import net.chandol.study.movieticket.movie.dto.MovieCreateRequest;
import net.chandol.study.movieticket.movie.model.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    MovieService movieService;

    @Test
    public void createMovie() {
        // given
        MovieCreateRequest request = new MovieCreateRequest("인셉션");

        // when
        Movie movie = movieService.createMovie(request);

        // then
        Movie retrievedMovie = movieService.getMovie(movie.getId());
        assertThat(retrievedMovie.getName()).isEqualTo(request.getName());
    }
}
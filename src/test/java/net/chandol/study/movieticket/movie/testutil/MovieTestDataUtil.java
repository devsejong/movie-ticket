package net.chandol.study.movieticket.movie.testutil;

import net.chandol.study.movieticket.movie.dto.MovieCreateRequest;
import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieTestDataUtil {
    @Autowired
    MovieService movieService;

    @Transactional
    public List<Movie> createMovies() {
        List<MovieCreateRequest> requests = Arrays.asList(
                new MovieCreateRequest("인셉션"),
                new MovieCreateRequest("인터스텔라")
        );

        List<Movie> movies = requests.stream()
                .map(r->movieService.createMovie(r))
                .collect(Collectors.toList());

        return movies;
    }

    @Transactional
    public Movie getMovieByName(String movieName) {
        return movieService.getMovieByName(movieName);
    }
}

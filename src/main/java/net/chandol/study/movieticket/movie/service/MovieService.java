package net.chandol.study.movieticket.movie.service;

import lombok.AllArgsConstructor;
import net.chandol.study.movieticket.movie.dto.MovieCreateRequest;
import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MovieService {

    MovieRepository movieRepository;

    @Transactional
    public Movie createMovie(MovieCreateRequest request) {
        Movie movie = new Movie(request.getName());
        return movieRepository.save(movie);
    }


    @Transactional(readOnly = true)
    public Movie getMovie(Long id) {
        return movieRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    public Movie getMovieByName(String movieName) {
        return movieRepository.getByName(movieName);
    }
}

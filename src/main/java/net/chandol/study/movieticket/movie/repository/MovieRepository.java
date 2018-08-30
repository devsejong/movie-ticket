package net.chandol.study.movieticket.movie.repository;

import net.chandol.study.movieticket.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie getByName(String name);
}

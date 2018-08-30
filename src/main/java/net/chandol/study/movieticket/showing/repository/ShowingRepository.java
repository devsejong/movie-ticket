package net.chandol.study.movieticket.showing.repository;

import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.showing.model.Showing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowingRepository extends JpaRepository<Showing, Long> {
    Page<Showing> findByMovie(Movie movie, Pageable pageable);
}

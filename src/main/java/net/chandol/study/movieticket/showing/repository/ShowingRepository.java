package net.chandol.study.movieticket.showing.repository;

import net.chandol.study.movieticket.showing.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowingRepository extends JpaRepository<Showing, Long> {
}

package net.chandol.study.movieticket.theater.repository;

import net.chandol.study.movieticket.theater.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
}

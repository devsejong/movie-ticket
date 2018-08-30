package net.chandol.study.movieticket.theater.repository;

import net.chandol.study.movieticket.theater.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
    Theater getByName(String name);
}

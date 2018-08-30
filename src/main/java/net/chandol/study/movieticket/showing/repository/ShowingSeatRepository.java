package net.chandol.study.movieticket.showing.repository;

import net.chandol.study.movieticket.showing.model.ShowingSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowingSeatRepository extends JpaRepository<ShowingSeat, Long>, ShowingSeatRepositoryCustom {
}

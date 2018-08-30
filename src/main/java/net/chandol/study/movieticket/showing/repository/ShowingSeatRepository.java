package net.chandol.study.movieticket.showing.repository;

import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.model.ShowingSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowingSeatRepository extends JpaRepository<ShowingSeat, Long> {
    @Query("select a" +
            "       from ShowingSeat a" +
            " inner join Showing b" +
            "         on a.showing = ?1" +
            " where s.status = net.chandol.study.movieticket.showing.model.ShowingSeatStatus.EMPTY"
    )
    List<ShowingSeat> getEmptySeats(Showing showing);
}

package net.chandol.study.movieticket.showing.repository;

import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.model.ShowingSeat;
import net.chandol.study.movieticket.theater.model.Seat;

import java.util.List;

public interface ShowingSeatRepositoryCustom {
    List<ShowingSeat> findShowingSeat(Showing showing, List<Seat> seats);
}

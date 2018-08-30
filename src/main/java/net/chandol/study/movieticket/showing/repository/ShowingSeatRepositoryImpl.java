package net.chandol.study.movieticket.showing.repository;

import net.chandol.study.movieticket.showing.model.QShowingSeat;
import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.model.ShowingSeat;
import net.chandol.study.movieticket.theater.model.QSeat;
import net.chandol.study.movieticket.theater.model.Seat;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ShowingSeatRepositoryImpl extends QuerydslRepositorySupport implements ShowingSeatRepositoryCustom {
    public ShowingSeatRepositoryImpl() {
        super(ShowingSeat.class);
    }

    @Override
    public List<ShowingSeat> findShowingSeat(Showing showing, List<Seat> seats) {
        QShowingSeat showingSeat = QShowingSeat.showingSeat;
        QSeat seat = QSeat.seat;

        return from(showingSeat)
                .innerJoin(seat)
                .fetchJoin()
                .where(showingSeat.showing.eq(showing))
                .where(seat.in(seats))
                .fetch();
    }

}

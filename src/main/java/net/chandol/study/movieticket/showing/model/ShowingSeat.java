package net.chandol.study.movieticket.showing.model;

import lombok.Getter;
import lombok.ToString;
import net.chandol.study.movieticket.theater.model.Seat;
import net.chandol.study.movieticket.user.model.User;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static net.chandol.study.movieticket.showing.model.ShowingSeatStatus.EMPTY;

@Entity
@Getter
@ToString(exclude = "showing")
public class ShowingSeat {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Showing showing;
    @ManyToOne
    private Seat seat;
    @Enumerated(STRING)
    private ShowingSeatStatus status = EMPTY;
    @ManyToOne
    private User user;

    protected ShowingSeat() {
    }

    public ShowingSeat(Showing showing, Seat seat) {
        this.seat = seat;
        this.setShowing(showing);
    }

    private void setShowing(Showing showing) {
        this.showing = showing;
        showing.addShowingSeat(this);
    }

    public void setUserAndStatus(User user, ShowingSeatStatus status) {
        this.user = user;
        this.status = status;
    }
}

package net.chandol.study.movieticket.theater.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Theater {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "theater")
    private List<Screen> screens = new ArrayList<>();

    protected Theater() {
    }

    public Theater(String name) {
        this.name = name;
    }

    void addScreen(Screen screen) {
        if (!screens.contains(screen)) {
            screens.add(screen);
        }
    }


}

package net.chandol.study.movieticket.showing.service;

import lombok.AllArgsConstructor;
import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.showing.dto.ShowingCreateRequest;
import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.model.ShowingSeat;
import net.chandol.study.movieticket.showing.repository.ShowingRepository;
import net.chandol.study.movieticket.showing.repository.ShowingSeatRepository;
import net.chandol.study.movieticket.theater.model.Screen;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ShowingService {
    ShowingRepository showingRepository;
    ShowingSeatRepository showingSeatRepository;

    @Transactional
    public Showing createShowing(Movie movie, Screen screen, ShowingCreateRequest request) {
        Showing showing = new Showing(movie, screen, request.getShowingAt());
        showingRepository.save(showing);

        List<ShowingSeat> showingSeats = screen.getSeats().stream()
                .map(seat->new ShowingSeat(showing, seat))
                .collect(toList());

        showingSeatRepository.saveAll(showingSeats);

        return showingRepository.save(showing);
    }

    @Transactional(readOnly = true)
    public Showing getShowing(Long id){
        return showingRepository.getOne(id);
    }


    @Transactional
    public Page<Showing> findShowingByMovie(Movie movie) {
        return showingRepository.findByMovie(movie);
    }
}

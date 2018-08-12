package net.chandol.study.movieticket.showing.service;

import lombok.AllArgsConstructor;
import net.chandol.study.movieticket.movie.model.Movie;
import net.chandol.study.movieticket.showing.dto.ShowingCreateRequest;
import net.chandol.study.movieticket.showing.model.Showing;
import net.chandol.study.movieticket.showing.repository.ShowingRepository;
import net.chandol.study.movieticket.theater.model.Screen;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ShowingService {
    ShowingRepository showingRepository;

    @Transactional
    public Showing createShowing(Movie movie, Screen screen, ShowingCreateRequest request) {
        Showing showing = new Showing(movie, screen, request.getShowingAt());
        return showingRepository.save(showing);
    }

    @Transactional(readOnly = true)
    public Showing getShowing(Long id){
        return showingRepository.getOne(id);
    }
}

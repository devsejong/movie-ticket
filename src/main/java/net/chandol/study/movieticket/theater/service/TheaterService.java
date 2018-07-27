package net.chandol.study.movieticket.theater.service;

import lombok.AllArgsConstructor;
import net.chandol.study.movieticket.theater.dto.TheaterCreateRequest;
import net.chandol.study.movieticket.theater.model.Theater;
import net.chandol.study.movieticket.theater.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TheaterService {
    TheaterRepository theaterRepository;

    @Transactional
    public Theater createTheater(TheaterCreateRequest request) {
        Theater theater = new Theater(request.getName());
        return theaterRepository.save(theater);
    }
}

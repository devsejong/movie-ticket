package net.chandol.study.movieticket.theater.service;

import net.chandol.study.movieticket.theater.dto.TheaterCreateRequest;
import net.chandol.study.movieticket.theater.model.Theater;
import net.chandol.study.movieticket.theater.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public Theater createTheater(TheaterCreateRequest request) {
        return theaterRepository.save(new Theater(request.getName()));
    }
}

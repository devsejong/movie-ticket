package net.chandol.study.movieticket.theater.service;

import lombok.AllArgsConstructor;
import net.chandol.study.movieticket.theater.dto.ScreenCreateRequest;
import net.chandol.study.movieticket.theater.model.Screen;
import net.chandol.study.movieticket.theater.model.Theater;
import net.chandol.study.movieticket.theater.repository.ScreenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ScreenService {
    ScreenRepository screenRepository;

    @Transactional
    public Screen createScreen(Theater theater, ScreenCreateRequest createRequest) {
        Screen screen = new Screen(theater, createRequest.getName());

        return screenRepository.save(screen);
    }

    @Transactional(readOnly = true)
    public Screen getScreen(Long screenId){
        return screenRepository.getOne(screenId);
    }

}

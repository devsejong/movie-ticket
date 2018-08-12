package net.chandol.study.movieticket.showing.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShowingCreateRequest {
    private LocalDateTime showingAt;

    public ShowingCreateRequest() {
    }

    public ShowingCreateRequest(LocalDateTime showingAt) {
        this.showingAt = showingAt;
    }
}

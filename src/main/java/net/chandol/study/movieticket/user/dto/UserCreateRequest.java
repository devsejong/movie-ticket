package net.chandol.study.movieticket.user.dto;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;
    private String password;

    public UserCreateRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

package net.chandol.study.movieticket.user.testutil;

import net.chandol.study.movieticket.user.dto.UserCreateRequest;
import net.chandol.study.movieticket.user.model.User;
import net.chandol.study.movieticket.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTestDataUtil {

    @Autowired
    UserService userService;

    @Transactional
    public List<User> createUsers() {
        List<UserCreateRequest> requests = Arrays.asList(
                new UserCreateRequest("sejong", "test1234"),
                new UserCreateRequest("aming", "test0124"),
                new UserCreateRequest("gamja", "woong")
        );

        List<User> users = requests.stream()
                .map(userService::createUser)
                .collect(Collectors.toList());

        return users;
    }

    @Transactional
    public User getUserByUsername(String name) {
        return userService.getUserByUsername(name);
    }

}

package net.chandol.study.movieticket.user.service;

import net.chandol.study.movieticket.user.dto.UserCreateRequest;
import net.chandol.study.movieticket.user.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void createUser() {
        // given
        UserCreateRequest request = new UserCreateRequest("sejong", "test1234");

        // when
        User user = userService.createUser(request);

        // then
        User retrievedUser = userService.getUser(user.getId());
        Assertions.assertThat(retrievedUser.getUsername()).isEqualTo("sejong");
    }
}
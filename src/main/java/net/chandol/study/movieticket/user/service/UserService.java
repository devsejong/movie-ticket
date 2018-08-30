package net.chandol.study.movieticket.user.service;

import net.chandol.study.movieticket.user.dto.UserCreateRequest;
import net.chandol.study.movieticket.user.model.User;
import net.chandol.study.movieticket.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User createUser(UserCreateRequest request) {
        User user = new User(request.getUsername(), request.getPassword());
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    public User getUserByUsername(String name) {
        return userRepository.getByUsername(name);
    }


}

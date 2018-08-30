package net.chandol.study.movieticket.user.repository;

import net.chandol.study.movieticket.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String name);
}

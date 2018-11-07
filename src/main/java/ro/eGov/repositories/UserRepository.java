package ro.eGov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ro.eGov.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAll();
    User findUserByEmail(String email);
}

package net.project2.springbootrestfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.project2.springbootrestfulwebservices.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

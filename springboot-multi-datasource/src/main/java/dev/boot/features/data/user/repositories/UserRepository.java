package dev.boot.features.data.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.boot.features.data.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

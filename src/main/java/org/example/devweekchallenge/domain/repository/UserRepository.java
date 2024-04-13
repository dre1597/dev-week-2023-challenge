package org.example.devweekchallenge.domain.repository;

import org.example.devweekchallenge.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}

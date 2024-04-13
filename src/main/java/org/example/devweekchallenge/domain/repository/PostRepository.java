package org.example.devweekchallenge.domain.repository;

import org.example.devweekchallenge.domain.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, String> {
}

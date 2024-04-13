package org.example.devweekchallenge.service.contracts;

import org.example.devweekchallenge.domain.model.Post;
import org.example.devweekchallenge.dto.CreatePostDto;
import org.example.devweekchallenge.dto.UpdatePostDto;

import java.util.List;

public interface IPostService {
  List<Post> findAll();

  Post create(CreatePostDto post);

  Post findById(String id);

  Post update(String id, UpdatePostDto post);

  void delete(String id);
}

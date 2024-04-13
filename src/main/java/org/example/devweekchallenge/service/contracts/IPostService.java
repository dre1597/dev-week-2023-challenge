package org.example.devweekchallenge.service.contracts;

import org.example.devweekchallenge.domain.model.Post;
import org.example.devweekchallenge.dto.CreatePost;
import org.example.devweekchallenge.dto.UpdatePost;

import java.util.List;

public interface IPostService {
  List<Post> findAll();

  Post create(CreatePost post);

  Post findById(String id);

  Post update(String id, UpdatePost post);

  void delete(String id);
}

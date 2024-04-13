package org.example.devweekchallenge.service;

import org.example.devweekchallenge.domain.model.Post;
import org.example.devweekchallenge.domain.repository.PostRepository;
import org.example.devweekchallenge.domain.repository.UserRepository;
import org.example.devweekchallenge.dto.CreatePost;
import org.example.devweekchallenge.dto.UpdatePost;
import org.example.devweekchallenge.exceptions.NotFoundException;
import org.example.devweekchallenge.service.contracts.IPostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostService implements IPostService {
  private final PostRepository postRepository;
  private final UserRepository userRepository;

  public PostService(final PostRepository postRepository, final UserRepository userRepository) {
    this.postRepository = Objects.requireNonNull(postRepository);
    this.userRepository = Objects.requireNonNull(userRepository);
  }

  @Override
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  @Override
  public Post create(final CreatePost post) {
    var author = userRepository.findById(post.authorId()).orElse(null);

    if (author == null) {
      throw new NotFoundException("Author not found");
    }
    return postRepository.save(post.toPost());
  }

  @Override
  public Post findById(final String id) {
    return postRepository.findById(id).orElse(null);
  }

  @Override
  public Post update(final String id, final UpdatePost post) {
    var author = userRepository.findById(post.authorId()).orElse(null);

    if (author == null) {
      throw new NotFoundException("Author not found");
    }

    return postRepository.save(post.toPost());
  }

  @Override
  public void delete(final String id) {
    postRepository.deleteById(id);
  }
}

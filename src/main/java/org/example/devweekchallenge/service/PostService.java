package org.example.devweekchallenge.service;

import org.example.devweekchallenge.domain.model.Post;
import org.example.devweekchallenge.domain.repository.PostRepository;
import org.example.devweekchallenge.domain.repository.UserRepository;
import org.example.devweekchallenge.dto.CreatePostDto;
import org.example.devweekchallenge.dto.UpdatePostDto;
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
  public Post create(final CreatePostDto postToCreate) {
    var author = userRepository.findById(postToCreate.authorId()).orElse(null);

    if (author == null) {
      throw new NotFoundException("Author not found");
    }

    var post = postToCreate.toPost();
    post.setAuthor(author);

    return postRepository.save(post);
  }

  @Override
  public Post findById(final String id) {
    return postRepository.findById(id).orElse(null);
  }

  @Override
  public Post update(final String id, final UpdatePostDto postToUpdate) {
    var postExists = postRepository.findById(id).orElse(null);
    var author = userRepository.findById(postToUpdate.authorId()).orElse(null);

    if (postExists == null) {
      throw new NotFoundException("Post not found");
    }

    if (author == null) {
      throw new NotFoundException("Author not found");
    }

    var post = postToUpdate.toPost();
    post.setId(id);
    post.setAuthor(author);

    return postRepository.save(postToUpdate.toPost());
  }

  @Override
  public void delete(final String id) {
    postRepository.deleteById(id);
  }
}

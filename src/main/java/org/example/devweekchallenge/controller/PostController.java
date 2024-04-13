package org.example.devweekchallenge.controller;

import jakarta.validation.Valid;
import org.example.devweekchallenge.domain.model.Post;
import org.example.devweekchallenge.dto.CreatePostDto;
import org.example.devweekchallenge.dto.UpdatePostDto;
import org.example.devweekchallenge.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/posts")
public class PostController {
  private final PostService service;

  public PostController(final PostService service) {
    this.service = Objects.requireNonNull(service);
  }

  @GetMapping
  public ResponseEntity<List<Post>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @PostMapping
  public ResponseEntity<Post> create(@RequestBody @Valid final CreatePostDto post) {
    return ResponseEntity.ok(service.create(post));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Post> findById(@PathVariable("id") final String id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Post> update(@PathVariable("id") final String id, @RequestBody @Valid final UpdatePostDto post) {
    return ResponseEntity.ok(service.update(id, post));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") final String id) {
    service.delete(id);
    return ResponseEntity.ok(id);
  }
}

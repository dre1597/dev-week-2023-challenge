package org.example.devweekchallenge.controller;

import org.example.devweekchallenge.domain.model.User;
import org.example.devweekchallenge.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService service;

  public UserController(final UserService service) {
    this.service = Objects.requireNonNull(service);
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @PostMapping
  public ResponseEntity<User> create(final User user) {
    return ResponseEntity.ok(service.create(user));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<User> findById(@PathVariable("id") final String id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<User> update(@PathVariable("id") final String id, final User user) {
    return ResponseEntity.ok(service.update(id, user));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") final String id) {
    service.delete(id);
    return ResponseEntity.ok(id);
  }
}

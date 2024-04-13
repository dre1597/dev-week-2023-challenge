package org.example.devweekchallenge.service.contracts;

import org.example.devweekchallenge.domain.model.User;

import java.util.List;

public interface IUserService {
  List<User> findAll();

  User create(User user);

  User findById(String id);

  User update(String id, User user);

  void delete(String id);
}

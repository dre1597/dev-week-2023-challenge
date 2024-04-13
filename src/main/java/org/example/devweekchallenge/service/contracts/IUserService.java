package org.example.devweekchallenge.service.contracts;

import org.example.devweekchallenge.domain.model.User;
import org.example.devweekchallenge.dto.CreateUser;
import org.example.devweekchallenge.dto.UpdateUser;

import java.util.List;

public interface IUserService {
  List<User> findAll();

  User create(CreateUser user);

  User findById(String id);

  User update(String id, UpdateUser user);

  void delete(String id);
}

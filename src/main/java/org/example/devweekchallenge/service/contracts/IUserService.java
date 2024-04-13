package org.example.devweekchallenge.service.contracts;

import org.example.devweekchallenge.domain.model.User;
import org.example.devweekchallenge.dto.CreateUserDto;
import org.example.devweekchallenge.dto.UpdateUserDto;

import java.util.List;

public interface IUserService {
  List<User> findAll();

  User create(CreateUserDto user);

  User findById(String id);

  User update(String id, UpdateUserDto user);

  void delete(String id);
}

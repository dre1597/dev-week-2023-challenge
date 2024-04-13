package org.example.devweekchallenge.service;

import org.example.devweekchallenge.domain.model.User;
import org.example.devweekchallenge.domain.repository.UserRepository;
import org.example.devweekchallenge.exceptions.BusinessException;
import org.example.devweekchallenge.exceptions.NotFoundException;
import org.example.devweekchallenge.service.contracts.IUserService;

import java.util.List;
import java.util.Objects;

public class UserService implements IUserService {
  private final UserRepository userRepository;

  public UserService(final UserRepository userRepository) {
    this.userRepository = Objects.requireNonNull(userRepository);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User create(final User userToCreate) {
    var user = userRepository.findByEmail(userToCreate.getEmail());

    if (user != null) {
      throw new BusinessException("User already exists");
    }

    return userRepository.save(userToCreate);
  }

  @Override
  public User findById(final String id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public User update(final String id, final User userToUpdate) {
    var user = userRepository.findById(id).orElse(null);
    var emailAlreadyExists = userRepository.findByEmail(userToUpdate.getEmail());

    if (user == null) {
      throw new NotFoundException("User not found");
    }

    if (emailAlreadyExists != null && !emailAlreadyExists.getId().equals(id) && emailAlreadyExists.getEmail().equals(userToUpdate.getEmail())) {
      throw new BusinessException("User already exists");
    }

    return userRepository.save(user);
  }

  @Override
  public void delete(final String id) {
    var user = userRepository.findById(id).orElse(null);

    if (user == null) {
      throw new NotFoundException("User not found");
    }

    userRepository.delete(user);
  }
}

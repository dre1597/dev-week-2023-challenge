package org.example.devweekchallenge.service;

import org.example.devweekchallenge.domain.model.User;
import org.example.devweekchallenge.domain.repository.UserRepository;
import org.example.devweekchallenge.dto.CreateUser;
import org.example.devweekchallenge.dto.UpdateUser;
import org.example.devweekchallenge.exceptions.BusinessException;
import org.example.devweekchallenge.exceptions.NotFoundException;
import org.example.devweekchallenge.service.contracts.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
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
  public User create(final CreateUser userToCreate) {
    var user = userRepository.findByEmail(userToCreate.email());

    if (user != null) {
      throw new BusinessException("User already exists");
    }
    return userRepository.save(userToCreate.toUser());
  }

  @Override
  public User findById(final String id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public User update(final String id, final UpdateUser userToUpdate) {
    var userExists = userRepository.findById(id).orElse(null);
    var emailAlreadyExists = userRepository.findByEmail(userToUpdate.email());

    if (userExists == null) {
      throw new NotFoundException("User not found");
    }

    if (emailAlreadyExists != null && !emailAlreadyExists.getId().equals(id) && emailAlreadyExists.getEmail().equals(userToUpdate.email())) {
      throw new BusinessException("User already exists");
    }

    var updatedUser = userToUpdate.toUser();
    updatedUser.setId(id);
    
    return userRepository.save(updatedUser);
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

package org.example.devweekchallenge.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.devweekchallenge.domain.model.User;

public record CreateUserDto(
    @NotNull @Size(min = 6, max = 100) String name,
    @NotNull @Email String email,
    @NotNull @Size(min = 8, max = 20) String password
) {

  public User toUser() {
    return new User(name, email, password);
  }
}

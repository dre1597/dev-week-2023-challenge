package org.example.devweekchallenge.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.devweekchallenge.domain.model.Post;
import org.hibernate.validator.constraints.UUID;

public record CreatePost(
    @NotNull @Size(min = 1, max = 100) String title,
    @NotNull @Size(min = 1, max = 1000) String content,
    @NotNull @UUID String authorId
) {

  public Post toPost() {
    return new Post(title, content);
  }
}

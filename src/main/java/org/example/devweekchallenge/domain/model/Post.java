package org.example.devweekchallenge.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column
  private String title;

  @Column
  private String content;

  @ManyToOne(fetch = FetchType.EAGER)
  private User author;

  public Post() {
  }

  public Post(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public Post(String id, String title, String content, User author) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Post post = (Post) o;
    return Objects.equals(getId(), post.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }
}

package org.example.devweekchallenge.exceptions;

public class BusinessException extends RuntimeException {
  public BusinessException(final String message) {
    super(message);
  }
}

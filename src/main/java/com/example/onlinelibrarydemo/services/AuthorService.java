package com.example.onlinelibrarydemo.services;

import com.example.onlinelibrarydemo.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(long id);
}

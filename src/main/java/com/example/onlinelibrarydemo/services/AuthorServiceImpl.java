package com.example.onlinelibrarydemo.services;

import com.example.onlinelibrarydemo.entities.Author;
import com.example.onlinelibrarydemo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<Author> getAuthorById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    @Transactional
    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }

    @Override
    @Transactional
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}

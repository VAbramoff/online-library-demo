package com.example.onlinelibrarydemo.services;

import com.example.onlinelibrarydemo.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    Optional<Book> getBookById(long id);

    void updateBook(Book book);

    void deleteBook(Book book);

    Book createBook(Book book);
}

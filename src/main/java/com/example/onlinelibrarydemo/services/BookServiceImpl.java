package com.example.onlinelibrarydemo.services;

import com.example.onlinelibrarydemo.entities.Book;
import com.example.onlinelibrarydemo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    @Transactional
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
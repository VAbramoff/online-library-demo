package com.example.onlinelibrarydemo.shell;

import com.example.onlinelibrarydemo.services.AuthorService;
import com.example.onlinelibrarydemo.services.BookService;
import com.example.onlinelibrarydemo.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.h2.tools.Console;
import org.springframework.shell.standard.ShellOption;

import java.sql.SQLException;

@ShellComponent
public class AppEventsCommands {

    private final AuthorService authorService;
    private final BookService bookService;
    private final GenreService genreService;

    @Autowired
    public AppEventsCommands(AuthorService authorService, BookService bookService, GenreService genreService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.genreService = genreService;
    }

    /**
     * Метод startConsoleH2 запускает консоль
     */
    @ShellMethod(value = "Start console H2", key = {"c", "console"})
    public void startConsoleH2() {
        try {
            Console.main();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @ShellMethod(value = "Get All Authors", key = {"gaa", "getallauthors"})
    public void getAllAuthors() {
        System.out.println(authorService.getAllAuthors().toString());
    }

    @ShellMethod(value = "Get Author By Id", key = {"gabi", "getauthorbyid"})
    public void getAuthorById(@ShellOption(defaultValue = "1") long id){
        System.out.println(authorService.getAuthorById(id).toString());
    }

    @ShellMethod(value = "Get All Books", key = {"gab", "getallbooks"})
    public void getAllBooks() {System.out.println(bookService.getAllBooks().toString());}

    @ShellMethod(value = "Get Book By Id", key = {"gbbi", "getbookbyid"})
    public void getBookById(@ShellOption(defaultValue = "1") long id){
        System.out.println(bookService.getBookById(id).toString());
    }

    @ShellMethod(value = "Get All Genres", key = {"gag", "getallgenres"})
    public void getAllGenres() {System.out.println(genreService.getAllGenres().toString());}

    @ShellMethod(value = "Get Genre By Id", key = {"ggbi", "getgenrebyid"})
    public void getGenreById(@ShellOption(defaultValue = "1") long id){
        System.out.println(genreService.getGenreById(id).toString());
    }
}

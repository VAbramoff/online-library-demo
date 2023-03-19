package com.example.onlinelibrarydemo.shell;

import com.example.onlinelibrarydemo.entities.Author;
import com.example.onlinelibrarydemo.entities.Book;
import com.example.onlinelibrarydemo.entities.Genre;
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

    //----------------------------------------------------------------------Authors
    @ShellMethod(value = "Get All Authors", key = {"gaa", "getallauthors"})
    public void getAllAuthors() {
        System.out.println(authorService.getAllAuthors().toString());
    }

    @ShellMethod(value = "Get Author By Id", key = {"gabi", "getauthorbyid"})
    public void getAuthorById(@ShellOption(defaultValue = "1") long id){
        System.out.println(authorService.getAuthorById(id).toString());
    }

    @ShellMethod(value = "Update Author Information", key = {"ua", "updateauthor"})
    public void updateAuthor(@ShellOption(defaultValue = "1") long id,
                             @ShellOption(defaultValue = "John Bunyan") String fullName){
        authorService.updateAuthor(new Author(id, fullName));
    }

    @ShellMethod(value = "Delete Author Data", key = {"da", "deleteauthor"})
    public void deleteAuthor(@ShellOption(defaultValue = "1") long id,
                             @ShellOption(defaultValue = "John Bunyan") String fullName){
        authorService.deleteAuthor(new Author(id, fullName));
    }

    @ShellMethod(value = "Create Author in library", key = {"ca", "createauthor"})
    public String createAuthor(@ShellOption(defaultValue = "Franz Kafka") String fullName){
        return authorService.createAuthor(new Author(fullName)).toString();
    }

    //----------------------------------------------------------------------Books
    @ShellMethod(value = "Get All Books", key = {"gab", "getallbooks"})
    public void getAllBooks() {System.out.println(bookService.getAllBooks().toString());}

    @ShellMethod(value = "Get Book By Id", key = {"gbbi", "getbookbyid"})
    public void getBookById(@ShellOption(defaultValue = "1") long id){
        System.out.println(bookService.getBookById(id).toString());
    }

    @ShellMethod(value = "Update Book Information", key = {"ub", "updatebook"})
    public void updateBook(@ShellOption(defaultValue = "1") long id,
                           @ShellOption(defaultValue = "The Pilgrim’s Progress") String title,
                           @ShellOption(defaultValue = "1") Author author,
                           @ShellOption(defaultValue = "1") Genre genre){
        bookService.updateBook(new Book(id, title, author, genre));
    }

    @ShellMethod(value = "Delete Book Information", key = {"db", "deletebook"})
    public void deleteBook(@ShellOption(defaultValue = "1") long id,
                           @ShellOption(defaultValue = "The Pilgrim’s Progress") String title)
    {
        bookService.deleteBook(new Book(id, title));
    }

    @ShellMethod(value = "Create New Book", key = {"cb", "createbook"})
    public void createBook(@ShellOption(defaultValue = "1") long id,
                           @ShellOption(defaultValue = "The Pilgrim’s Progress") String title,
                           @ShellOption(defaultValue = "1") Author author,
                           @ShellOption(defaultValue = "1") Genre genre){
        bookService.createBook(new Book(id, title, author, genre));
    }

    //----------------------------------------------------------------------Genres
    @ShellMethod(value = "Get All Genres", key = {"gag", "getallgenres"})
    public void getAllGenres() {System.out.println(genreService.getAllGenres().toString());}

    @ShellMethod(value = "Get Genre By Id", key = {"ggbi", "getgenrebyid"})
    public void getGenreById(@ShellOption(defaultValue = "1") long id){
        System.out.println(genreService.getGenreById(id).toString());
    }

    @ShellMethod(value = "Update Genre  Information", key = {"ug", "updategenre"})
    public void updateGenre(@ShellOption(defaultValue = "1") long id,
                            @ShellOption(defaultValue = "History") String name){
        genreService.updateGenre(new Genre(id,name));
    }

    @ShellMethod(value = "Delete Genre Data", key = {"dg", "deletegenre"})
    public void deleteGenre(@ShellOption(defaultValue = "1") long id,
                            @ShellOption(defaultValue = "History") String name){
        genreService.deleteGenre(new Genre(id,name));
    }

    @ShellMethod(value = "Create Genre in library", key = {"cg", "creategenre"})
    public String createGenre(@ShellOption(defaultValue = "Novella") String name){
        return genreService.createGenre(new Genre(name)).toString();
    }
}

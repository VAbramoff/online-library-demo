package com.example.onlinelibrarydemo.shell;

import com.example.onlinelibrarydemo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.h2.tools.Console;
import java.sql.SQLException;

@ShellComponent
public class AppEventsCommands {

    private final AuthorService authorService;

    @Autowired
    public AppEventsCommands(AuthorService authorService) {
        this.authorService = authorService;
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
}

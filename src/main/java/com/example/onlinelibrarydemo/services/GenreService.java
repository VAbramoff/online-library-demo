package com.example.onlinelibrarydemo.services;

import com.example.onlinelibrarydemo.entities.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    List<Genre> getAllGenres();

    Optional<Genre> getGenreById(long id);

    void updateGenre(Genre genre);

    void deleteGenre(Genre genre);

    Genre createGenre(Genre genre);
}

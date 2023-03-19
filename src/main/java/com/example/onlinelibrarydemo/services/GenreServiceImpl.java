package com.example.onlinelibrarydemo.services;

import com.example.onlinelibrarydemo.entities.Genre;
import com.example.onlinelibrarydemo.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService{

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Genre> getGenreById(long id) {
        return genreRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateGenre(Genre genre){
        genreRepository.save(genre);
    }

    @Override
    @Transactional
    public void deleteGenre(Genre genre) {
        genreRepository.delete(genre);
    }

    @Override
    @Transactional
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }
}

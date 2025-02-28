package site.liuye.demo.service;

import site.liuye.demo.domain.Movie;

import java.util.List;

public interface MovieService {
    Movie getMovieById(Long id);

    List<Movie> getAllMovies();

    List<Movie> getMoviesByCondition(String title, Long categoryId, String area);

    boolean addMovie(Movie movie);

    boolean modifyMovie(Movie movie);

    boolean removeMovie(Long id);

    List<Movie> getAllMovies(int offset, int limit);

    int countAllMovies();
}

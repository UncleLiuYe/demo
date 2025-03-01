package site.liuye.demo.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import site.liuye.demo.entity.Movie;
import site.liuye.demo.mapper.MovieMapper;
import site.liuye.demo.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Resource
    private MovieMapper movieMapper;

    @Override
    public Movie getMovieById(Long id) {
        return movieMapper.findById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieMapper.findAll();
    }

    @Override
    public List<Movie> getMoviesByCondition(String title, Long categoryId, String area) {
        return movieMapper.findMoviesByCondition(title, categoryId, area);
    }

    @Override
    public boolean addMovie(Movie movie) {
        return movieMapper.insertMovie(movie) > 0;
    }

    @Override
    public boolean modifyMovie(Movie movie) {
        return movieMapper.updateMovie(movie) > 0;
    }

    @Override
    public boolean removeMovie(Long id) {
        return movieMapper.deleteMovie(id) > 0;
    }

    @Override
    public List<Movie> getAllMovies(int offset, int limit) {
        return movieMapper.findAllMovies(offset, limit);
    }

    @Override
    public int countAllMovies() {
        return movieMapper.countAllMovies();
    }
}

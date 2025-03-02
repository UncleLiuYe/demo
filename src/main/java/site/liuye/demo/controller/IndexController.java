package site.liuye.demo.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.liuye.demo.entity.Movie;
import site.liuye.demo.service.MovieService;

import java.util.List;

@Slf4j
@RestController
public class IndexController {
    @Resource
    private MovieService movieService;

    @GetMapping("test")
    public List<Movie> index() {
        return movieService.getAllMovies();
    }
}

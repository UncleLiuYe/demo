package site.liuye.demo.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.liuye.demo.domain.Movie;
import site.liuye.demo.service.MovieService;

import java.util.List;

@Slf4j
@Controller
public class IndexController {
    @Resource
    private MovieService movieService;

    @GetMapping("test")
    @ResponseBody
    public List<Movie> index() {
        return movieService.getAllMovies();
    }
}

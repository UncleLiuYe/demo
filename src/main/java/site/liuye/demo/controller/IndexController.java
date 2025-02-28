package site.liuye.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import site.liuye.demo.domain.Movie;
import site.liuye.demo.service.MovieService;

import java.util.List;

@Controller
public class IndexController {
    @Resource
    private MovieService movieService;

    @GetMapping("/")
    public String index(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}

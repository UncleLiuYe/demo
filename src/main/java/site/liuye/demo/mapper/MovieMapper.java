package site.liuye.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import site.liuye.demo.entity.Movie;

import java.util.List;

@Mapper
public interface MovieMapper {
    int insertMovie(Movie movie);

    int deleteMovie(Long id);

    int updateMovie(Movie movie);

    Movie findById(Long id);

    List<Movie> findAll();

    List<Movie> findMoviesByCondition(@Param("title") String title, @Param("categoryId") Long categoryId, @Param("area") String area);

    List<Movie> findAllMovies(@Param("offset") int offset, @Param("limit") int limit);

    int countAllMovies();
}
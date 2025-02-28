package site.liuye.demo.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Movie {
    private Long id;
    private String title;
    private String alias;
    private String director;
    private String actors;
    private Long categoryId;
    private String area;
    private String language;
    private Integer releaseYear;
    private LocalDateTime updateTime;
    private String description;
    private String coverImage;
    private String type;
}
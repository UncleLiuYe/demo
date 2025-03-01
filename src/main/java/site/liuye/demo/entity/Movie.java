package site.liuye.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private String description;
    private String coverImage;
    private String type;
}
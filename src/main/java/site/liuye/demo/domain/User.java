package site.liuye.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    @JsonIgnore
    private Boolean accountLocked;
    @JsonIgnore
    private LocalDateTime registrationTime;
}
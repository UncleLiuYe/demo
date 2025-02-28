package site.liuye.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.liuye.demo.domain.User;
import site.liuye.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class HelloController {
    @Resource
    private UserService userService;

    @GetMapping("hello")
    public ResponseEntity<List<User>> hello() {
        return ResponseEntity.ok(userService.listUsers());
    }
}

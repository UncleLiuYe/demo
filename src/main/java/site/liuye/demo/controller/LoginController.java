package site.liuye.demo.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.liuye.demo.entity.LoginRequest;
import site.liuye.demo.entity.LoginResponse;
import site.liuye.demo.service.UserService;
import site.liuye.demo.util.ApiResponse;

@Slf4j
@RestController
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse loginResponse = userService.login(request.getUsername(), request.getPassword());
        return ApiResponse.success(loginResponse);
    }
}
package site.liuye.demo.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.liuye.demo.entity.LoginRequest;
import site.liuye.demo.entity.User;
import site.liuye.demo.service.UserService;
import site.liuye.demo.util.ApiResponse;

@RestController
public class RegisterController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse<?> register(@Valid @RequestBody LoginRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEnabled(true);
        user.setLocked(false);
        user.setDeleted(false);
        int res = userService.saveUser(user);
        if (res > 0) {
            return ApiResponse.successMessage("注册成功");
        } else {
            return ApiResponse.failure(ApiResponse.ApiResponseCode.INTERNAL_SERVER_ERROR, "注册失败");
        }
    }
}

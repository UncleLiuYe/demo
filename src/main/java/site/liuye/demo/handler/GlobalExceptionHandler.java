package site.liuye.demo.handler;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.liuye.demo.util.ApiResponse;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ApiResponse.failure(ApiResponse.ApiResponseCode.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ApiResponse<?> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        return ApiResponse.failure(ApiResponse.ApiResponseCode.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ApiResponse<?> handleBadCredentialsException(BadCredentialsException ex) {
        return ApiResponse.failure(ApiResponse.ApiResponseCode.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ApiResponse<?> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        return ApiResponse.failure(ApiResponse.ApiResponseCode.BAD_REQUEST, "用户名重复");
    }
}

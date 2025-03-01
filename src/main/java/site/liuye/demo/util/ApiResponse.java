package site.liuye.demo.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

/**
 * 通用API响应类
 *
 * @param <T> 响应数据的数据类型，可以使用任何Java类型，例如对象、列表、基本类型等
 */
@Getter
public class ApiResponse<T> {

    // Getter 方法
    /**
     * 响应状态码
     * 通常使用 HTTP 状态码，例如 200 表示成功，400 表示客户端错误，500 表示服务器错误等
     * 你可以根据自己的业务需求定义更详细的状态码
     */
    private int code;

    /**
     * 响应消息
     * 用于描述响应状态的文本信息，例如 "操作成功", "用户名不能为空", "服务器内部错误" 等
     */
    private String message;

    /**
     * 响应数据
     * 实际返回给客户端的数据，类型由泛型 <T> 指定
     * 当操作成功且需要返回数据时，该字段会被填充
     * 使用 @JsonInclude(JsonInclude.Include.NON_NULL) 注解表示，当 data 为 null 时，JSON 序列化时忽略该字段
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    /**
     * 私有构造器，防止外部直接创建实例，强制使用静态工厂方法
     * 这样做可以更好地控制对象创建过程，并提供更语义化的创建方法
     */
    private ApiResponse() {
    }

    /**
     * 私有构造器，用于创建包含状态码和消息的响应
     *
     * @param code    状态码
     * @param message 消息
     */
    private ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 私有构造器，用于创建包含状态码、消息和数据的响应
     *
     * @param code    状态码
     * @param message 消息
     * @param data    数据
     */
    private ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 静态工厂方法，创建成功响应，默认状态码为 200，消息为 "操作成功"
     *
     * @param <T> 响应数据的数据类型
     * @return ApiResponse<T> 成功响应对象
     */
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getMessage());
    }

    /**
     * 静态工厂方法，创建成功响应，并携带数据，默认状态码为 200，消息为 "操作成功"
     *
     * @param data 响应数据
     * @param <T>  响应数据的数据类型
     * @return ApiResponse<T> 成功响应对象
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getMessage(), data);
    }

    /**
     * 静态工厂方法，创建成功响应，可以自定义消息，状态码仍然为 200
     *
     * @param message 自定义成功消息
     * @param <T>     响应数据的数据类型
     * @return ApiResponse<T> 成功响应对象
     */
    public static <T> ApiResponse<T> successMessage(String message) {
        return new ApiResponse<>(ApiResponseCode.SUCCESS.getCode(), message);
    }

    /**
     * 静态工厂方法，创建失败响应，使用预定义的错误码和消息
     *
     * @param apiResponseCode 错误码枚举
     * @param <T>             响应数据的数据类型
     * @return ApiResponse<T> 失败响应对象
     */
    public static <T> ApiResponse<T> failure(ApiResponseCode apiResponseCode) {
        return new ApiResponse<>(apiResponseCode.getCode(), apiResponseCode.getMessage());
    }

    /**
     * 静态工厂方法，创建失败响应，使用预定义的错误码，并自定义消息
     *
     * @param apiResponseCode 错误码枚举
     * @param message         自定义错误消息
     * @param <T>             响应数据的数据类型
     * @return ApiResponse<T> 失败响应对象
     */
    public static <T> ApiResponse<T> failure(ApiResponseCode apiResponseCode, String message) {
        return new ApiResponse<>(apiResponseCode.getCode(), message);
    }

    /**
     * 静态工厂方法，创建自定义失败响应，可以完全自定义状态码和消息
     *
     * @param code    自定义状态码
     * @param message 自定义错误消息
     * @param <T>     响应数据的数据类型
     * @return ApiResponse<T> 失败响应对象
     */
    public static <T> ApiResponse<T> failure(int code, String message) {
        return new ApiResponse<>(code, message);
    }


    /**
     * 内部枚举类，定义API响应状态码和消息
     * 你可以根据自己的业务需求扩展或修改这些状态码
     */
    @Getter
    public enum ApiResponseCode {
        SUCCESS(200, "操作成功"),
        BAD_REQUEST(400, "客户端请求错误"),
        UNAUTHORIZED(401, "未授权"),
        FORBIDDEN(403, "禁止访问"),
        NOT_FOUND(404, "资源未找到"),
        INTERNAL_SERVER_ERROR(500, "服务器内部错误");

        private final int code;
        private final String message;

        ApiResponseCode(int code, String message) {
            this.code = code;
            this.message = message;
        }

    }
}
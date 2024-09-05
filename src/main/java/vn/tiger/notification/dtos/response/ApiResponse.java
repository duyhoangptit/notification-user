package vn.tiger.notification.dtos.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse<T> {

    private int status;
    private T data;
    private String message;

    public static <T> ApiResponse responseOK(T data) {
        return ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(data)
                .build();
    }

    public static ApiResponse responseOK() {
        return ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .build();
    }

    public static ApiResponse responseError(int code, String message) {
        return ApiResponse.builder().status(code).message(message).build();
    }
}

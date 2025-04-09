package com.ErikV121.card_service.dto;

public class ResponseUtil {

    public static <T> ResponseDto<T> success(String message, T data, Object metadata) {
        return new ResponseDto<>("success", message, data, metadata);
    }

    public static <T> ResponseDto<T> error(String message, T data) {
        return new ResponseDto<>("error", message, data, null);
    }
}

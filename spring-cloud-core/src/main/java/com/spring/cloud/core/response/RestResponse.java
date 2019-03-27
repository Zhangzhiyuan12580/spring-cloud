package com.spring.cloud.core.response;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class RestResponse<T> implements Serializable {
    private int code;
    private T data;
    private String message;

    public static final RestResponse OK = new RestResponse(HttpStatus.OK);

    private RestResponse() {
    }

    private RestResponse(T data, String... message) {
        this.code = HttpStatus.OK.value();
        this.data = data;
        this.message = StringUtils.join(message);
    }

    private RestResponse(HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
    }

    private RestResponse(HttpStatus httpStatus, String... message) {
        this.code = httpStatus.value();
        this.message = StringUtils.join(message);
    }

    public static <T> RestResponse<T> ok(T data, String... message) {
        return new RestResponse<>(data, message);
    }

    public static RestResponse msg(String... message) {
        return new RestResponse<>(HttpStatus.OK, message);
    }

    public static RestResponse fail(String... message) {
        return new RestResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public static RestResponse of(HttpStatus httpStatus) {
        return new RestResponse<>(httpStatus, httpStatus.getReasonPhrase());
    }
}


package com.samp.common.exception;

public class BadRequestException extends DefaultNestedRuntimeException{
    public BadRequestException(String code) {
        super(code);
    }

    public BadRequestException(String code, String reason) {
        super(code, reason);
    }

    public BadRequestException(String code, String reason, Object data) {
        super(code, reason, data);
    }

    public BadRequestException(String code, String reason, Throwable cause) {
        super(code, reason, cause);
    }

    public BadRequestException(String code, String reason, Object data, Throwable cause) {
        super(code, reason, data, cause);
    }
}

package com.samp.common.exception;

public class ResourceNotFoundException extends DefaultNestedRuntimeException{
    public ResourceNotFoundException(String code) {
        super(code);
    }

    public ResourceNotFoundException(String code, String reason) {
        super(code, reason);
    }

    public ResourceNotFoundException(String code, String reason, Object data) {
        super(code, reason, data);
    }

    public ResourceNotFoundException(String code, String reason, Throwable cause) {
        super(code, reason, cause);
    }

    public ResourceNotFoundException(String code, String reason, Object data, Throwable cause) {
        super(code, reason, data, cause);
    }
}

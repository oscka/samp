package com.samp.common.exception;

public class BizRuntimeException extends DefaultNestedRuntimeException{
    public BizRuntimeException(String code) {
        super(code);
    }

    public BizRuntimeException(String code, String reason) {
        super(code, reason);
    }

    public BizRuntimeException(String code, String reason, Object data) {
        super(code, reason, data);
    }

    public BizRuntimeException(String code, String reason, Throwable cause) {
        super(code, reason, cause);
    }

    public BizRuntimeException(String code, String reason, Object data, Throwable cause) {
        super(code, reason, data, cause);
    }
}

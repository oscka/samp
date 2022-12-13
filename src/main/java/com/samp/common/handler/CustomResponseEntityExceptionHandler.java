package com.samp.common.handler;

import com.samp.common.exception.BadRequestException;
import com.samp.common.exception.BizRuntimeException;
import com.samp.common.exception.InterfaceException;
import com.samp.common.exception.ResourceNotFoundException;
import feign.FeignException;
import io.lettuce.core.RedisException;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@Order(0)
@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @PostConstruct
    public void init() {
        log.debug("RestExceptionHander Initialization");
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        log.error("Exception ##handleExceptionInternal : {}", ex.getMessage());
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        log.error("Exception ##handleBadRequestException : {},", exception.getReason());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BizRuntimeException.class)
    public ResponseEntity<Object> handleBizRuntimeException(BizRuntimeException exception) {
        log.error("Exception ##handleBizRuntimeException : {}", exception.getReason());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RedisException.class)
    public ResponseEntity<Object> heandleRedisOperatorException(RedisException exception) {
        log.error("Exception ##heandleRedisOperatorException : {}", exception.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> heandleFeignException(FeignException exception) {
        log.error("Exception ##heandleFeignException : {}", exception.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InterfaceException.class)
    public ResponseEntity<Object> heandlerInterfaceException(InterfaceException exception) {
        log.error("Exception ##heandlerInterfaceException : {}", exception.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

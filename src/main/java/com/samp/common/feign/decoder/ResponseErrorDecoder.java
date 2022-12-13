package com.samp.common.feign.decoder;

import com.samp.common.dto.ResultMessage;
import com.samp.common.exception.InterfaceException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ResponseErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ResultMessage resultMessage = null;
        String responseBody = null;
        try {
            log.error("Feign 요청 시 성공하지 못했습니다. response body : {}", responseBody);
            responseBody = Util.toString(response.body().asReader(Util.UTF_8));
            resultMessage.builder().successYn("N").message(responseBody).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new InterfaceException(response.status(), resultMessage, response.request());
    }
}

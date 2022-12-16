package com.samp.common.utils;

import com.samp.common.dto.ResultMessage;
import com.samp.common.exception.InterfaceException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionUtil {

    public static ResultMessage getResponseMessage(Throwable cause) {
        log.error("[Error] response error : {}", cause);

        if(cause instanceof InterfaceException) {
            return ((InterfaceException) cause).getResponseMessage();
        }

        ResultMessage resultMessage = ResultMessage.builder().successYn("N").message("요청이 성공하지 못했습니다.").build();

        return resultMessage;

    }
}

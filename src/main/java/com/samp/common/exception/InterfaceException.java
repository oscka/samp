package com.samp.common.exception;

import com.samp.common.dto.ResultMessage;
import com.samp.common.utils.JsonUtils;
import feign.FeignException;
import feign.Request;

public class InterfaceException extends FeignException {

  private static final long serialVersionUID = 894457625883918695L;
  

  public InterfaceException(int status, String message, Request request) {
    super(status, message, request);
  }

  public InterfaceException(int status, ResultMessage resultMessage, Request request) {
    super(status, JsonUtils.toJson(resultMessage), request);
  }

  public ResultMessage getResponseMessage() {
    return JsonUtils.readJson(this.getMessage(), ResultMessage.class);
  }

}

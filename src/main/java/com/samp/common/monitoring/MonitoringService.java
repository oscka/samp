package com.samp.common.monitoring;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MonitoringService {

    public void sendRequestData(HttpServletRequest request) {
        log.debug("Send request Data");
    }

    public void sendResponseData(HttpServletRequest request, HttpServletResponse response) {
        log.debug(("Send request and response Data"));
    }
}

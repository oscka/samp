package com.samp.common.interceptor;

import com.samp.common.http.HttpUtil;
import com.samp.common.monitoring.MonitoringService;
import com.samp.common.utils.CommonBeanUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LoggingHttpInterceptor implements HandlerInterceptor {

    private MonitoringService monitoringService;

    public LoggingHttpInterceptor() {
        this.monitoringService = (MonitoringService) CommonBeanUtil.getBean(MonitoringService.class);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        log.info("[preHandle]");
        monitoringService.sendRequestData(request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[postHandle]");
        monitoringService.sendResponseData(request, response);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) throws Exception {
        log.debug("[afterCompletion]");
    }
}

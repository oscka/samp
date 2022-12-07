package com.samp.common.config;

import com.samp.common.filter.RequestResponseWrapperFilter;
import com.samp.common.interceptor.LoggingHttpInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingHttpInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/system/*");
    }

    @Bean
    public RequestResponseWrapperFilter requestResponseWrapperFilter() {
        return new RequestResponseWrapperFilter();
    }
}

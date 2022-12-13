package com.samp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.samp")
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class SampApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampApplication.class, args);
    }

}

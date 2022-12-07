package com.samp.common.endpoint.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemEndpoint {

    @GetMapping("/system/healthz")
    public String healthz() {
        return "Service Healthy";
    }

}

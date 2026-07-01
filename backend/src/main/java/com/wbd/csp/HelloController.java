package com.wbd.csp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @Value("${app.version:unknown}")
    private String version;

    @Value("${app.env:local}")
    private String env;

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of(
            "message", "Hello from CSP Demo!",
            "version", version,
            "env",     env
        );
    }
}

package com.wbd.csp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CspDemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void helloEndpointReturnsMessage() {
        @SuppressWarnings("unchecked")
        Map<String, String> response = restTemplate
            .getForObject("http://localhost:" + port + "/hello", Map.class);
        assertThat(response).containsKey("message");
        assertThat(response.get("message")).contains("Hello");
    }

    @Test
    void actuatorHealthReturnsUp() {
        @SuppressWarnings("unchecked")
        Map<String, Object> response = restTemplate
            .getForObject("http://localhost:" + port + "/actuator/health", Map.class);
        assertThat(response.get("status")).isEqualTo("UP");
    }
}

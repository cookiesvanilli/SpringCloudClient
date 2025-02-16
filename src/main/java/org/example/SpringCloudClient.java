package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
public class SpringCloudClient implements CommandLineRunner {

    @Value("${user.role}")
    private String role;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClient.class, args);
    }

    @GetMapping(
            value = "/about/{username}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String about(@PathVariable("username") String username) {
        return String.format("Hello! You're %s and you'll become a(n) %s...\n", username, role);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
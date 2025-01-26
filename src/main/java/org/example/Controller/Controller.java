package org.example.Controller;

import org.example.Config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Config appConfig;

    public Controller(Config appConfig) {
        this.appConfig = appConfig;
    }

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/message")
    public String getMessage() {
        String profileMessage = (activeProfile != null && !activeProfile.isEmpty())
                ? "Active profile: " + activeProfile
                : "No active profile";

        String message = (appConfig.getMessage() != null && !appConfig.getMessage().isEmpty())
                ? appConfig.getMessage()
                : "Default message!";

        return profileMessage + "</br>" + message;
    }
}

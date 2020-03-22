package com.targa.labs.myBoutique.auth.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties (prefix = "user")
public class StartupProperties {
    private String username;
    private String password;
    private Character status;
}

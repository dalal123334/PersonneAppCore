package org.sid.personnecore.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;
import java.util.stream.Collectors;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "role-to-bf")
@PropertySource("classpath:role-to-bf.properties")
public class RoleMappingConfig {

    private Map<String, String> roleApiMappings;

    @Bean
    public Map<String, String[]> roleApiMap() {
        return roleApiMappings.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().split(","))
                );
    }
}
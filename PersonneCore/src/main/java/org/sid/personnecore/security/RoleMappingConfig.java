package org.sid.personnecore.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "keycloak.role-mappings")
public class RoleMappingConfig {
    private Map<String, String> mappings = new HashMap<>();

    public Map<String, String> getMappings() {
        return mappings;
    }

    public void setMappings(Map<String, String> mappings) {
        this.mappings = mappings;
    }

    public String[] getPermissionsForRole(String role) {
        String permissions = mappings.get(role);
        if (permissions == null) {
            return new String[0];
        }
        return permissions.split(",");
    }
}
package org.sid.personnecore.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:role-to-bf.properties")
@ConfigurationProperties(prefix = "role")
public class RoleMappingConfig {
    private final Map<String, String[]> rolePermissions = new HashMap<>();

    public Map<String, String[]> getRolePermissions() {
        return rolePermissions;
    }

    public String[] getPermissionsForRole(String role) {
        return rolePermissions.getOrDefault(role, new String[0]);
    }

    public void setAdmin(String permissions) {
        rolePermissions.put("ROLE_Admin", permissions.split(","));
    }

    public void setUser(String permissions) {
        rolePermissions.put("ROLE_User", permissions.split(","));
    }
}
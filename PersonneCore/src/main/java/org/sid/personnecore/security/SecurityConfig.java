//package org.sid.personnecore.security;
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.*;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
//@AllArgsConstructor
//public class SecurityConfig {
//
//    private final RoleMappingConfig roleMappingConfig;
//
//
//
//    public Collection<GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
//        Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
//
//        for (GrantedAuthority authority : authorities) {
//            String roleName = authority.getAuthority();
//            String[] permissions = roleMappingConfig.getPermissionsForRole(roleName);
//
//            for (String permission : permissions) {
//                mappedAuthorities.add(new SimpleGrantedAuthority(permission));
//            }
//        }
//
//        return mappedAuthorities;
//    }
//
//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverter() {
//        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
//        JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
//
//        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
//            Collection<GrantedAuthority> authorities = authoritiesConverter.convert(jwt);
//            return mapAuthorities(authorities);
//        });
//
//        return converter;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/api/personnes/**").hasAnyAuthority(
//                                "BFF_CREATE_PERSONNE",
//                                "BFF_MODIFIER_PERSONNE",
//                                "BFF_DELETE_PERSONNE",
//                                "BFF_VIEW_PERSONNE"
//                        )
//                        .anyRequest().authenticated()
//                )
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .jwt(jwt -> jwt
//                                .jwtAuthenticationConverter(jwtAuthenticationConverter())
//                        )
//                );
//
//        return http.build();
//    }
//}
//
//

//package org.sid.personnecore.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
//import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class CustomGrantedAuthoritiesMapper implements GrantedAuthoritiesMapper {
//    @Autowired
//    private RoleMappingConfig roleMappingConfig;
//
//    @Override
//    public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
//        Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
//
//        for (GrantedAuthority authority : authorities) {
//            if (authority instanceof OAuth2UserAuthority) {
//                OAuth2UserAuthority oauth2UserAuthority = (OAuth2UserAuthority) authority;
//                String roleName = oauth2UserAuthority.getAuthority();
//                String[] permissions = roleMappingConfig.getPermissionsForRole(roleName);
//
//                for (String permission : permissions) {
//                    mappedAuthorities.add(new SimpleGrantedAuthority(permission));
//                }
//            }
//        }
//
//        return mappedAuthorities;
//    }
//}

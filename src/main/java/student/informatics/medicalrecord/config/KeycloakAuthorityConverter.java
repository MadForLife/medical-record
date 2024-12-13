package student.informatics.medicalrecord.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakAuthorityConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {

        final Map<String, Object> realmAccess =
                (Map<String, Object>) source.getClaims().getOrDefault("realm_access", Collections.emptyMap());

        final Collection<String> roles =
                (Collection<String>) realmAccess.getOrDefault("roles", Collections.emptyList());

        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}

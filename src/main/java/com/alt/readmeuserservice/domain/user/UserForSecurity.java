package com.alt.readmeuserservice.domain.user;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Builder
public class UserForSecurity implements UserDetails {
    private final PasswordEncoder passwordEncoder;
    private static final long serialVersionUID = 1L;
    @NonNull
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if(user.getType().equals('S')) {
            authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        }
        else if(user.getType().equals('A')) {
            authorities.add(new SimpleGrantedAuthority("ROLE_SCHOOL"));
        }
        else if(user.getType().equals('E')) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ENTERPRISE"));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

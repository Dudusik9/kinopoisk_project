package org.example.kinopoisk_project.security;

import lombok.Data;
import org.example.kinopoisk_project.entity.User;
import org.example.kinopoisk_project.model.Role;
import org.springframework.expression.ExpressionException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CustomUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;

    public CustomUserDetails(String nickname, String password, List<SimpleGrantedAuthority> authorities) {
        this.username = nickname;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

    public static UserDetails UserToUserDetailsConvert(User user){
        return new org.springframework.security.core.userdetails.User(
              user.getNickname(),
              user.getPassword(),
                true,
                true,
                true,
                true,
//              Заглушка, необходимо разобрать как вытаскивать из Set User его конкретную роль
                Role.ADMIN.getAuthorities()
//                Необходимо отладить
//                user.getRole().stream().findFirst().orElseThrow(() -> new IllegalArgumentException("Role didn't find")).getAuthorities()
        );
    }
}

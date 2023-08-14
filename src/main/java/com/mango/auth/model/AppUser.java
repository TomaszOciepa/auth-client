package com.mango.auth.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Document
@Getter
@Setter
public class AppUser implements UserDetails {

    @Id
    private String appUserId;

    @NotBlank
    @Size(max = 20)
    @Indexed(unique = true)
    private String username;

    @NotBlank
    @Size(min = 5)
    private String password;

    private Set<Role> authorities = new HashSet<>();

    private boolean enabled;

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
}

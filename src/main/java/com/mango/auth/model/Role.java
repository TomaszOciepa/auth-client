package com.mango.auth.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {
    public enum ERole {
        ROLE_STUDENT,
        ROLE_ADMIN
    }

    @Id
    private String roleId;

    private ERole role;

    public Role(ERole role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.name();
    }
}

package com.mango.auth.model.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AppUserDto {
    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(min = 5)
    private String password;
}

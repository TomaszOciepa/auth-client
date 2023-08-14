package com.mango.auth.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class AppUserInfo {

    private String username;

    private List<String> roles = new ArrayList<>();

    private boolean enabled;
}

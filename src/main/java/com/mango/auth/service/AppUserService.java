package com.mango.auth.service;

import com.mango.auth.model.dto.AppUserDto;
import com.mango.auth.model.dto.AppUserInfo;

import java.util.List;

public interface AppUserService {

    List<AppUserInfo> getUsers();

    String createUser(AppUserDto appUserDto);

    void activeUserAsStudent(String id);
}

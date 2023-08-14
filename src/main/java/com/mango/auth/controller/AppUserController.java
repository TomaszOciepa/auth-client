package com.mango.auth.controller;

import com.mango.auth.model.dto.AppUserDto;
import com.mango.auth.model.dto.AppUserInfo;
import com.mango.auth.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @RolesAllowed({"ROLE_ADMIN"})
    @GetMapping
    public List<AppUserInfo> getUsers() {
        return appUserService.getUsers();
    }

    @PostMapping("/registriation")
    public String addUser(@RequestBody @Valid AppUserDto appUserDto) {
        return appUserService.createUser(appUserDto);
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<?> activeUserAsStudent(@PathVariable String id) {
        appUserService.activeUserAsStudent(id);
        return ResponseEntity.ok().build();
    }
}

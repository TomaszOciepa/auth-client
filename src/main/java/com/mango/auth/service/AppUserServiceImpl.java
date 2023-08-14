package com.mango.auth.service;

import com.mango.auth.model.AppUser;
import com.mango.auth.model.dto.AppUserDto;
import com.mango.auth.model.dto.AppUserInfo;
import com.mango.auth.repository.AppUserRepository;
import com.mango.auth.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mango.auth.model.Role.ERole.ROLE_STUDENT;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public List<AppUserInfo> getUsers() {
        return appUserRepository.findAll()
                .stream()
                .map(appUser -> convertAppUserToAppUserInfo(appUser))
                .collect(Collectors.toList());
    }

    @Override
    public String createUser(AppUserDto appUserDto) {
        AppUser appUser = convertAppUserDtoToAppUser(appUserDto);
        return appUserRepository.save(appUser).getAppUserId();
    }

    @Override
    public void activeUserAsStudent(String id) {
        appUserRepository.findById(id).ifPresent(
                appUser -> {
                    appUser.setEnabled(true);
                    appUser.getAuthorities().add(roleRepository.findByRole(ROLE_STUDENT));
                    appUserRepository.save(appUser);
                }
        );
    }

    private AppUserInfo convertAppUserToAppUserInfo(AppUser appUser) {
        AppUserInfo appUserInfo = new AppUserInfo();
        appUserInfo.setUsername(appUser.getUsername());
        appUserInfo.setEnabled(appUser.isEnabled());
        appUser.getAuthorities()
                .forEach(user -> appUserInfo.getRoles().add(user.getRole().name()));
        return appUserInfo;
    }

    private AppUser convertAppUserDtoToAppUser(AppUserDto appUserDto) {
        AppUser appUser = new AppUser();
        appUser.setUsername(appUserDto.getUsername());
        appUser.setUsername(appUserDto.getUsername());
        appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
        return appUser;
    }
}

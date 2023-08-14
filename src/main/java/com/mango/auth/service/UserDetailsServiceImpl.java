package com.mango.auth.service;

import com.mango.auth.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// adnotacja wrzuca wszystkie final pola do konstruktora. Nie trzeba wstrzykiwać do konstruktora.
@RequiredArgsConstructor
@Service("myUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username);
    }
}

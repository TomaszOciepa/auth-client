package com.mango.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
//jsr250Enabled = true - pozwala na używanie adnotacji @RolesAllowed() w kontrolerze, za pomocą, którch można definiować role użytkowników
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/registriation").permitAll()
                .antMatchers("/users/*/activate").permitAll()
                .anyRequest().authenticated();
    }
}

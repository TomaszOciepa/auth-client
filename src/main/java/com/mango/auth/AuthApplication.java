package com.mango.auth;

import com.mango.auth.model.Role;
import com.mango.auth.repository.RoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import static com.mango.auth.model.Role.ERole.ROLE_ADMIN;
import static com.mango.auth.model.Role.ERole.ROLE_STUDENT;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	public InitializingBean loadData(RoleRepository repository){
		System.out.println("SIEMA!!");
		return () -> {
			if(!repository.existsByRole(ROLE_STUDENT)){
				repository.save(new Role(ROLE_STUDENT));
			}
			if(!repository.existsByRole(ROLE_ADMIN)){
				repository.save(new Role(ROLE_ADMIN));
			}
		};
	}

}

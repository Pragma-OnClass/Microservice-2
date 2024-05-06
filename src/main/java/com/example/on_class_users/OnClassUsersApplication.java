package com.example.on_class_users;

import com.example.on_class_users.domain.api.IRoleServicePort;
import com.example.on_class_users.domain.api.IUserServicePort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class OnClassUsersApplication implements CommandLineRunner {
	private final IUserServicePort userServicePort;
	private final IRoleServicePort roleServicePort;
	public OnClassUsersApplication(IUserServicePort userServicePort, IRoleServicePort roleServicePort ) {
		this.userServicePort = userServicePort;
		this.roleServicePort = roleServicePort;
	}
	public static void main(String[] args) {
		SpringApplication.run(OnClassUsersApplication.class, args);
	}

	@Override
	public void run(String... args) {
		roleServicePort.createDefaultRole("SUPER_ADMIN");
		roleServicePort.createDefaultRole("ADMIN");
		roleServicePort.createDefaultRole("TUTOR");
		roleServicePort.createDefaultRole("STUDENT");
		userServicePort.createSuperAdmin();
	}

}

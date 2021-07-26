package com.studentnetwork.Student.Network;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class StudentNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentNetworkApplication.class, args);
	}

}

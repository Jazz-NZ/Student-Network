package com.studentnetwork.Student.Network;

import com.studentnetwork.Student.Network.database.UserRepository;
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

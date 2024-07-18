package com.gerenciadordetelefone.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.gerenciadordetelefone.Principal.Model")
@EnableJpaRepositories(basePackages = "com.gerenciadordetelefone.Principal.repository")
public class PrincipalApplication {
	public static void main(String[] args) {
		SpringApplication.run(PrincipalApplication.class, args);
	}
}

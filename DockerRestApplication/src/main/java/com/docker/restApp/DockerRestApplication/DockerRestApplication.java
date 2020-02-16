package com.docker.restApp.DockerRestApplication;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.docker.*")
@EntityScan("com.docker.*")
@EnableTransactionManagement
@EnableJpaRepositories("com.docker.*")
public class DockerRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerRestApplication.class, args);
	}

}

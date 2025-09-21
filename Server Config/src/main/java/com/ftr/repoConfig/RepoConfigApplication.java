package com.ftr.repoConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class RepoConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepoConfigApplication.class, args);
	}

}

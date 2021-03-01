package com.br.systemvoting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SystemVotingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemVotingApplication.class, args);
	}

}

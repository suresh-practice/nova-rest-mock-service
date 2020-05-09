package com.suresh.practice.nova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NovaRestMockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovaRestMockServiceApplication.class, args);
	}

}

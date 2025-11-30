package com.svm.jobsphere.orchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JobOrchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobOrchestratorApplication.class, args);
	}

}

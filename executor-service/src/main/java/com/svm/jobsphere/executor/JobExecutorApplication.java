package com.svm.jobsphere.executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JobExecutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobExecutorApplication.class, args);
	}

    @Bean
    @LoadBalanced // 👈 Must be present!
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }
}

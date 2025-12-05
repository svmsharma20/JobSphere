package com.svm.jobsphere.executor.service;

import com.svm.jobsphere.executor.model.ExecutionResult;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CallbackService {

    private final WebClient webClient;

    public CallbackService(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://SCHEDULER-SERVICE")
                .build();
    }

    public void sendResult(ExecutionResult result) {
        String response = webClient.post()
                .uri("/scheduler/callback")
                .bodyValue(result)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> {
                    System.err.println("Callback to Scheduler failed: " + e.getMessage());
                    return Mono.error(new RuntimeException("Callback failed", e));
                }).block();
        System.out.println(response);
    }
}

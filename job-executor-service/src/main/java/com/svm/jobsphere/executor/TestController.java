package com.svm.jobsphere.executor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/executor")
public class TestController {

    private final WebClient webClient;

    public TestController(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://ORCHESTRATOR-SERVICE") // 👈 Must use the exact Service ID (usually uppercase)
                .build();;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello2")
    public Mono<String> hello2() {

        System.out.println("Attempting to call Orchestrator service...");

        return webClient.get()
                .uri("/orchestrator/hello")
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> {
                    System.err.println("Error calling Orchestrator: " + e.getMessage());
                    return Mono.just("Error: Could not retrieve hello message.");
                });
    }
}

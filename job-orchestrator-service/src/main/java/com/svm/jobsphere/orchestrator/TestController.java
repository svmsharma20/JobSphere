package com.svm.jobsphere.orchestrator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orchestrator")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("------hello----");
        return "hello";
    }
}

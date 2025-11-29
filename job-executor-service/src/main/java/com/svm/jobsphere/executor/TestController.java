package com.svm.jobsphere.executor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/executor")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

package com.svm.jobsphere.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

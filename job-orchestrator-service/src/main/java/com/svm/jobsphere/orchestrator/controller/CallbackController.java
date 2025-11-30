package com.svm.jobsphere.orchestrator.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orchestrator")
public class CallbackController {

    @PostMapping("/callback")
    public String callback(@RequestBody ExecutionResult executionResult){
        System.out.println("====== Orchestrator Callback ======");
        System.out.println(executionResult);
        return "Success";
    }
}

package com.svm.jobsphere.executor.controller;

import com.svm.jobsphere.executor.model.ExecutionRequest;
import com.svm.jobsphere.executor.service.ExecutionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/executor")
public class ExecutionController {

    private final ExecutionService executionService;

    public ExecutionController(ExecutionService executionService) {
        this.executionService = executionService;
    }

    @PostMapping("/run")
    public String runJob(@RequestBody ExecutionRequest executionRequest) {
        executionService.executeAsync(executionRequest);
        return "Job accepted: " + executionRequest.getJobId();
    }
}

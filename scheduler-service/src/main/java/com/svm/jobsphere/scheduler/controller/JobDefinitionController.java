package com.svm.jobsphere.scheduler.controller;

import com.svm.jobsphere.scheduler.dto.CreateJobRequest;
import com.svm.jobsphere.scheduler.dto.JobResponse;
import com.svm.jobsphere.scheduler.dto.UpdateJobRequest;
import com.svm.jobsphere.scheduler.service.JobDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scheduler/jobs")
@RequiredArgsConstructor
public class JobDefinitionController {

    private final JobDefinitionService service;

    @PostMapping
    public JobResponse create(@RequestBody CreateJobRequest request) {
        return service.createJob(request);
    }

    @GetMapping
    public List<JobResponse> getAll() {
        return service.getAllJobs();
    }

    @GetMapping("/{apiName}")
    public JobResponse get(@PathVariable String apiName) {
        return service.getJob(apiName);
    }

    @PutMapping("/{apiName}")
    public JobResponse update(
            @PathVariable String apiName,
            @RequestBody UpdateJobRequest request) {

        return service.updateJob(apiName, request);
    }

    @DeleteMapping("/{apiName}")
    public JobResponse delete(@PathVariable String apiName) {
        return service.deleteJob(apiName);
    }
}

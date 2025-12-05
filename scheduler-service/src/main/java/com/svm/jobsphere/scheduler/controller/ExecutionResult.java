package com.svm.jobsphere.scheduler.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExecutionResult {
    private String jobId;
    private String status; // SUCCESS / FAILED
    private String logs;
    private String output;
}

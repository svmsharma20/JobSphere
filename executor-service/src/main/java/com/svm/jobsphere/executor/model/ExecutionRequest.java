package com.svm.jobsphere.executor.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class ExecutionRequest {
    private String jobId;
    private ExecutorType type; // SHELL, HTTP, JAVA
    private Map<String, Object> params;
}

package com.svm.jobsphere.executor.service.executors;

import com.svm.jobsphere.executor.model.ExecutionRequest;
import com.svm.jobsphere.executor.model.ExecutionResult;

public interface JobExecutor {
    ExecutionResult execute(ExecutionRequest request);
}

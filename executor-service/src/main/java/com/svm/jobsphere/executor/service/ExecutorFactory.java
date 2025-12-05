package com.svm.jobsphere.executor.service;

import com.svm.jobsphere.executor.model.ExecutorType;
import com.svm.jobsphere.executor.service.executors.JobExecutor;
import com.svm.jobsphere.executor.service.executors.ShellJobExecutor;
import org.springframework.stereotype.Service;

@Service
public class ExecutorFactory {

    public JobExecutor getExecutor(ExecutorType type) {
        return switch (type) {
            case SHELL -> new ShellJobExecutor();
            default      -> throw new IllegalArgumentException("Unknown job type: " + type);
        };
    }
}

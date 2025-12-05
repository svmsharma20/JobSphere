package com.svm.jobsphere.executor.service;

import com.svm.jobsphere.executor.model.ExecutionRequest;
import com.svm.jobsphere.executor.model.ExecutionResult;
import com.svm.jobsphere.executor.service.executors.JobExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class ExecutionService {
    private final ExecutorFactory executorFactory;
    private final CallbackService callbackService;
    private final ThreadPoolTaskExecutor executorPool;

    public ExecutionService(ExecutorFactory executorFactory,
                            CallbackService callbackService) {

        this.executorFactory = executorFactory;
        this.callbackService = callbackService;

        // thread pool for parallel job execution
        this.executorPool = new ThreadPoolTaskExecutor();
        this.executorPool.setCorePoolSize(5);
        this.executorPool.setMaxPoolSize(10);
        this.executorPool.setQueueCapacity(50);
        this.executorPool.initialize();
    }

    public void executeAsync(ExecutionRequest executionRequest) {
        executorPool.submit(() -> execute(executionRequest));
    }

    private void execute(ExecutionRequest req) {
        JobExecutor executor = executorFactory.getExecutor(req.getType());

        ExecutionResult result = executor.execute(req);
         System.out.println(result.getOutput());
        callbackService.sendResult(result);
    }
}

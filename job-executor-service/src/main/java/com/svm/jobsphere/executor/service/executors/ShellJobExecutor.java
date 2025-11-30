package com.svm.jobsphere.executor.service.executors;

import com.svm.jobsphere.executor.model.ExecutionRequest;
import com.svm.jobsphere.executor.model.ExecutionResult;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShellJobExecutor implements JobExecutor{
    @Override
    public ExecutionResult execute(ExecutionRequest request) {
        ExecutionResult result = new ExecutionResult();
        result.setJobId(request.getJobId());

        try {
            String command = request.getParams().get("command").toString();

//            Process process = Runtime.getRuntime().exec(command);
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe",
                    "/c",
                    command
            );
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();

            result.setOutput(output.toString());
            result.setLogs("Exit code: " + exitCode);
            result.setStatus(exitCode == 0 ? "SUCCESS" : "FAILED");

        } catch (Exception e) {
            result.setStatus("FAILED");
            result.setLogs(e.getMessage());
        }

        return result;
    }
}

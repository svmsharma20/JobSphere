package com.svm.jobsphere.scheduler.service;

import com.svm.jobsphere.scheduler.dto.CreateJobRequest;
import com.svm.jobsphere.scheduler.dto.JobResponse;
import com.svm.jobsphere.scheduler.dto.UpdateJobRequest;
import com.svm.jobsphere.scheduler.entity.JobDefinition;
import com.svm.jobsphere.scheduler.repository.JobDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobDefinitionService {

    private final JobDefinitionRepository repo;

    public JobResponse createJob(CreateJobRequest request) {
        JobDefinition job = new JobDefinition();
        job.setName(request.getName());
        job.setName(request.getApiName());
        job.setDescription(request.getDescription());
        job.setJobType(request.getJobType());
        job.setScheduleType(request.getScheduleType());
        job.setCronExpression(request.getCronExpression());
        job.setExecutionContext(request.getExecutionContext());
        job.setIsActive(request.getIsActive());
        repo.save(job);

        return toResponse(job);
    }

    public List<JobResponse> getAllJobs() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public JobResponse getJob(String apiName) {
        return repo.findByApiName(apiName)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public JobResponse updateJob(String apiName, UpdateJobRequest request) {
        JobDefinition job = repo.findByApiName(apiName)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setDescription(request.getDescription());
        job.setScheduleType(request.getScheduleType());
        job.setCronExpression(request.getCronExpression());
        job.setExecutionContext(request.getExecutionContext());
        job.setIsActive(request.getIsActive());
        repo.save(job);

        return toResponse(job);
    }

    public JobResponse deleteJob(String apiName) {
        JobDefinition job =  repo.deleteByApiName(apiName)
                                 .orElseThrow(() -> new RuntimeException("Job not found"));

        return toResponse(job);
    }

    private JobResponse toResponse(JobDefinition job) {
        return new JobResponse(
                job.getName(),
                job.getApiName(),
                job.getDescription(),
                job.getJobType(),
                job.getScheduleType(),
                job.getCronExpression(),
                job.getExecutionContext(),
                job.getIsActive(),
                job.getCreatedAt(),
                job.getLastModifiedAt()
        );
    }
}

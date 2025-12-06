package com.svm.jobsphere.scheduler.dto;

import com.svm.jobsphere.scheduler.entity.JobType;
import com.svm.jobsphere.scheduler.entity.ScheduleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobRequest{
    private String name;
    private String apiName;
    private String description;
    private JobType jobType;
    private ScheduleType scheduleType;
    private String cronExpression;
    private String executionContext;
    private Boolean isActive;
}


package com.svm.jobsphere.scheduler.dto;

import com.svm.jobsphere.scheduler.entity.ScheduleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateJobRequest{
    private String description;
    private ScheduleType scheduleType;
    private String cronExpression;
    private String executionContext;
    private Boolean isActive;
}


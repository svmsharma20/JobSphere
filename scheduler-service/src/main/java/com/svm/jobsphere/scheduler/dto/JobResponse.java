package com.svm.jobsphere.scheduler.dto;

import com.svm.jobsphere.scheduler.entity.JobType;
import com.svm.jobsphere.scheduler.entity.ScheduleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {
    private String name;
    private String apiName;
    private String description;
    private JobType jobType;
    private ScheduleType scheduleType;
    private String cronExpression;
    private String requestPayload;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

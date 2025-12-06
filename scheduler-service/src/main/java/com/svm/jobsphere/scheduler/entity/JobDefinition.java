package com.svm.jobsphere.scheduler.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job_definition")
public class JobDefinition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "api_name", unique = true, nullable = false, updatable = false)
    private String apiName;

    private String description;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Enumerated(EnumType.STRING)
    private ScheduleType scheduleType;
    private String cronExpression;

    private String executionContext;
    private Boolean isActive;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime lastModifiedAt = LocalDateTime.now();

    @PreUpdate
    public void preUpdate() {
        lastModifiedAt = LocalDateTime.now();
    }

    @PrePersist
    protected void setDefaultValuesIfAbsent() {
        if (this.apiName == null || this.apiName.trim().isEmpty()) {
            this.apiName = this.name.trim().replace(" ","");
        }

        if (this.isActive == null) {
            this.isActive = Boolean.TRUE;
        }
    }


}

package com.svm.jobsphere.scheduler.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "job_execution_history")
public class JobExecutionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private JobDefinition job;

    @Enumerated(EnumType.STRING)
    private TriggerType triggerType;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private JobExecutionStatus status;

    private String executorId;

    @Lob
    private String requestPayload;

    @Lob
    private String responsePayload;

    private String errorMessage;

    private LocalDateTime createdAt = LocalDateTime.now();
}


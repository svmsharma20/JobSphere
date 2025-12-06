package com.svm.jobsphere.scheduler.repository;

import com.svm.jobsphere.scheduler.entity.JobDefinition;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobDefinitionRepository extends JpaRepository<JobDefinition, Long> {

    Optional<JobDefinition> findByApiName(String apiName);

    @Transactional
    Optional<JobDefinition> deleteByApiName(String apiName);
}

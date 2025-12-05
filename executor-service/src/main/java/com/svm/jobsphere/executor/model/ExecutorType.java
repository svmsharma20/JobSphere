package com.svm.jobsphere.executor.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

public enum ExecutorType {
//    Map<String, boolean> configList;
    SHELL;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ExecutorType fromValue(String value) {
        return ExecutorType.valueOf(value.toUpperCase());
    }
}

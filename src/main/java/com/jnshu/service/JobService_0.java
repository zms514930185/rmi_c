package com.jnshu.service;

import com.jnshu.model.Job;

import java.util.List;

public interface JobService_0 {
    List<Job> selectJobSelective(Job job);
    int deleteByPrimaryKey(Long id);
}

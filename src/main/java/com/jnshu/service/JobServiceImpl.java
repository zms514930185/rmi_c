package com.jnshu.service;

import com.jnshu.model.Job;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class JobServiceImpl implements JobService {
    private final Logger log = LogManager.getLogger(this.getClass());
    @Resource
    JobService_0 JobService_0;
    @Resource
    JobService_1 JobService_1;
    @Override
    public List<Job> selectJobSelective(Job job) {
        int random = new Random().nextInt(2);
        try {
            if (random == 0) {
                try {
                    log.info("连接服务器0");
                    return JobService_0.selectJobSelective(job);
                } catch (Exception e) {
                    log.info("服务器0出错，连接服务器1");
                    return JobService_1.selectJobSelective(job);
                }
            } else {
                try {
                    log.info("连接服务器1");
                    return JobService_1.selectJobSelective(job);
                } catch (Exception e) {
                    log.info("服务器1出错，连接服务器0");
                    return JobService_0.selectJobSelective(job);
                }
            }
        } catch (Exception e) {
            log.info("服务器全军覆没");
            return null;
        }
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        int random = new Random().nextInt(2);
        try {
            if (random == 0) {
                try {
                    log.info("连接服务器0");
                    return JobService_0.deleteByPrimaryKey(id);
                } catch (Exception e) {
                    log.info("服务器0出错，连接服务器1");
                    return JobService_1.deleteByPrimaryKey(id);
                }
            } else {
                try {
                    log.info("连接服务器1");
                    return JobService_1.deleteByPrimaryKey(id);
                } catch (Exception e) {
                    log.info("服务器1出错，连接服务器0");
                    return JobService_0.deleteByPrimaryKey(id);
                }
            }
        } catch (Exception e) {
            log.info("服务器全军覆没");
            return 0;
        }
    }
}

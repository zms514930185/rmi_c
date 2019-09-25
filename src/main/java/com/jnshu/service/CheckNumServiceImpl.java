package com.jnshu.service;

import com.jnshu.model.CheckNum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class CheckNumServiceImpl implements CheckNumService {
    private final Logger log = LogManager.getLogger(this.getClass());
    @Resource
    CheckNumService_0 checkNumService_0;
    @Resource
    CheckNumService_1 checkNumService_1;


    @Override
    public List<CheckNum> selectSelective(CheckNum record) {
        int random = new Random().nextInt(2);
        try {
            if (random == 0) {
                try {
                    log.info("连接服务器0");
                    return checkNumService_0.selectSelective(record);
                } catch (Exception e) {
                    log.info("服务器0出错，连接服务器1");
                    return checkNumService_1.selectSelective(record);
                }
            } else {
                try {
                    log.info("连接服务器1");
                    return checkNumService_1.selectSelective(record);
                } catch (Exception e) {
                    log.info("服务器1出错，连接服务器0");
                    return checkNumService_0.selectSelective(record);
                }
            }
        } catch (Exception e) {
            log.info("服务器全军覆没");
            return null;
        }
    }

    @Override
    public int insertSelective(CheckNum record) {
        int random = new Random().nextInt(2);
        try {
            if (random == 0) {
                try {
                    log.info("连接服务器0");
                    return checkNumService_0.insertSelective(record);
                } catch (Exception e) {
                    log.info("服务器0出错，连接服务器1");
                    return checkNumService_1.insertSelective(record);
                }
            } else {
                try {
                    log.info("连接服务器1");
                    return checkNumService_1.insertSelective(record);
                } catch (Exception e) {
                    log.info("服务器1出错，连接服务器0");
                    return checkNumService_0.insertSelective(record);
                }
            }
        } catch (Exception e) {
            log.info("服务器全军覆没");
            return 0;
        }
    }

    @Override
    public int updateSelective(CheckNum record) {
        int random = new Random().nextInt(2);
        try {
            if (random == 0) {
                try {
                    log.info("连接服务器0");
                    return checkNumService_0.updateSelective(record);
                } catch (Exception e) {
                    log.info("服务器0出错，连接服务器1");
                    return checkNumService_1.updateSelective(record);
                }
            } else {
                try {
                    log.info("连接服务器1");
                    return checkNumService_1.updateSelective(record);
                } catch (Exception e) {
                    log.info("服务器1出错，连接服务器0");
                    return checkNumService_0.updateSelective(record);
                }
            }
        } catch (Exception e) {
            log.info("服务器全军覆没");
            return 0;
        }
    }
}

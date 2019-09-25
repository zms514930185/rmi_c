package com.jnshu.service;

import com.jnshu.model.User;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LogManager.getLogger(this.getClass());
    @Resource
    UserService_0 userService_0;
    @Resource
    UserService_1 userService_1;
    @Override
    public List<User> selectUserSelective(User user) throws InterruptedException, MemcachedException, TimeoutException {
        int random = new Random().nextInt(2);
        try {
            if (random == 0) {
                try {
                    log.info("连接服务器0");
                    return userService_0.selectUserSelective(user);
                } catch (Exception e) {
                    log.info("服务器0出错，连接服务器1");
                    return userService_1.selectUserSelective(user);
                }
            } else {
                try {
                    log.info("连接服务器1");
                    return userService_1.selectUserSelective(user);
                } catch (Exception e) {
                    log.info("服务器1出错，连接服务器0");
                    return userService_0.selectUserSelective(user);
                }
            }
        } catch (Exception e) {
            log.info("服务器全军覆没");
            return null;
        }
    }

    @Override
    public int insertSelective(User record) {
        int random = new Random().nextInt(2);
        try {
            if (random == 0) {
                try {
                    log.info("连接服务器0");
                    return userService_0.insertSelective(record);
                } catch (Exception e) {
                    log.info("服务器0出错，连接服务器1");
                    return userService_1.insertSelective(record);
                }
            } else {
                try {
                    log.info("连接服务器1");
                    return userService_1.insertSelective(record);
                } catch (Exception e) {
                    log.info("服务器1出错，连接服务器0");
                    return userService_0.insertSelective(record);
                }
            }
        } catch (Exception e) {
            log.info("服务器全军覆没");
            return 0;
        }
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        int random = new Random().nextInt(2);
        try {
            if (random == 0) {
                try {
                    log.info("连接服务器0");
                    return userService_0.updateByPrimaryKeySelective(record);
                } catch (Exception e) {
                    log.info("服务器0出错，连接服务器1");
                    return userService_1.updateByPrimaryKeySelective(record);
                }
            } else {
                try {
                    log.info("连接服务器1");
                    return userService_1.updateByPrimaryKeySelective(record);
                } catch (Exception e) {
                    log.info("服务器1出错，连接服务器0");
                    return userService_0.updateByPrimaryKeySelective(record);
                }
            }
        } catch (Exception e) {
            log.info("服务器全军覆没");
            return 0;
        }
    }
}

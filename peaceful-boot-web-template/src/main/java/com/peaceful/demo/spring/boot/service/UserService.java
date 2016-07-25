package com.peaceful.demo.spring.boot.service;

import com.peaceful.demo.spring.boot.dao.UserDao;
import com.peaceful.demo.spring.boot.domin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WangJun
 * @version 1.0 16/6/4
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findById(long id) {
        return userDao.findById(id);
    }
}

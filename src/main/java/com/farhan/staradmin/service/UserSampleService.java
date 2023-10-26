package com.farhan.staradmin.service;

import com.farhan.staradmin.mapper.UserSampleMapper;
import com.farhan.staradmin.model.UserSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSampleService {
    @Autowired
    private UserSampleMapper userSampleMapper;

    public List<UserSample> selectAllUsers() {
        return this.userSampleMapper.selectAllUsers();
    }

    public UserSample selectOneUserById(Long id) {
        return this.userSampleMapper.selectOneUserById(id);
    }

    public void updateUser(UserSample userSample) {
        userSampleMapper.updateUser(userSample);
    }

    public void quitUserById(Long id) {
        userSampleMapper.quitUserById(id);
    }

    public void createUser(UserSample userSample) {
        userSampleMapper.createUser(userSample);
    }
}

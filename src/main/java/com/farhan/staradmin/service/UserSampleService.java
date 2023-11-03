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

    public int countAllUsers() {
        return this.userSampleMapper.countAllUsers();
    }

    public List<UserSample> selectAllUsers(int currentPage, int limit) {
        int offset = (currentPage - 1) * limit;
        return this.userSampleMapper.selectAllUsers(limit, offset);
    }

    public int countSearchedUsers(String keyword) {
        return this.userSampleMapper.countSearchedUsers(keyword);
    }

    public List<UserSample> searchUsers(String keyword, int currentPage, int limit) {
        int offset = (currentPage - 1) * limit;
        return this.userSampleMapper.searchUsers(keyword, limit, offset);
    }

    public UserSample selectOneUserById(Long id) {
        return this.userSampleMapper.selectOneUserById(id);
    }

    public void updateUser(UserSample userSample) {
        this.userSampleMapper.updateUser(userSample);
    }

    public void quitUserById(Long id) {
        this.userSampleMapper.quitUserById(id);
    }

    public void createUser(UserSample userSample) {
        this.userSampleMapper.createUser(userSample);
    }
}

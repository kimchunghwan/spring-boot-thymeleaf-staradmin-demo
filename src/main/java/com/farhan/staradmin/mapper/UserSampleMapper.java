package com.farhan.staradmin.mapper;

import com.farhan.staradmin.model.UserSample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserSampleMapper {
    List<UserSample> selectAllUsers();
    UserSample selectOneUserById(Long id);
    void updateUser(UserSample userSample);
    void quitUserById(Long id);
    void createUser(UserSample userSample);
    /*
    */
}
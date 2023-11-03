package com.farhan.staradmin.mapper;

import com.farhan.staradmin.model.UserSample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserSampleMapper {
    int countAllUsers();
    List<UserSample> selectAllUsers(@Param("limit") int limit, @Param("offset") int offset);
    int countSearchedUsers(@Param("keyword") String keyword);
    List<UserSample> searchUsers(@Param("keyword") String keyword, @Param("limit") int limit, @Param("offset") int offset);
    UserSample selectOneUserById(Long id);
    void updateUser(UserSample userSample);
    void quitUserById(Long id);
    void createUser(UserSample userSample);
}
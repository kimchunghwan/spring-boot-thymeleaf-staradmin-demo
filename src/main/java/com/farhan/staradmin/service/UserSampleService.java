package com.farhan.staradmin.service;

import com.farhan.staradmin.mapper.UserSampleMapper;
import com.farhan.staradmin.model.UserSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;


@Service
public class UserSampleService {

=======

@Service
public class UserSampleService {
    @Autowired
>>>>>>> origin/bwy/user
    private UserSampleMapper mapper;

    public ArrayList<UserSample> findUser() {
        return this.mapper.find();
<<<<<<< HEAD

    }

=======
    }
>>>>>>> origin/bwy/user
}

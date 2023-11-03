package com.farhan.staradmin.mapper;

import com.farhan.staradmin.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface MemberMapper {
    ArrayList<Member> find();
}

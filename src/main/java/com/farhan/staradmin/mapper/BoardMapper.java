package com.farhan.staradmin.mapper;

import com.farhan.staradmin.domain.BoardDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {

    int boardCount();

    List<BoardDTO> getList();
}
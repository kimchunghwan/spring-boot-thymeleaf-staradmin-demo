package com.farhan.staradmin.service;

import java.util.List;

import com.farhan.staradmin.domain.BoardDTO;
import com.farhan.staradmin.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardMapper boardMapper;

    public int boardCount(){return boardMapper.boardCount();}

    public List<BoardDTO> boardList(){return boardMapper.getList();}

}
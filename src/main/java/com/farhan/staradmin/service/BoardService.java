package com.farhan.staradmin.service;

import java.util.ArrayList;
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

    // 게시판 리스트 조회
    public List<BoardDTO> boardList(){return boardMapper.getList();}

    // 게시판 상세 내용 조회
    public BoardDTO getBoard(int id){return boardMapper.getBoard(id);}

    // 내용 생성

    @Transactional
    public void uploadBoard(BoardDTO board) {
        boardMapper.uploadBoard(board);
    }

    @Transactional
    public void updateBoard(BoardDTO board) { boardMapper.updateBoard(board); }

    @Transactional
    public void deleteBoard(Long id) { boardMapper.deleteBoard(id); }


//    public ArrayList<BoardDTO> findBoard() {
//        return this.boardMapper.find();
//    }
}
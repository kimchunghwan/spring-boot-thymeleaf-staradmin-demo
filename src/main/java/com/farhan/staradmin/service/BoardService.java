package com.farhan.staradmin.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.farhan.staradmin.domain.BoardAPI;
import com.farhan.staradmin.domain.BoardDTO;
import com.farhan.staradmin.domain.Pagination;
import com.farhan.staradmin.domain.PagingResponse;
import com.farhan.staradmin.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardMapper boardMapper;

    // 게시판 리스트 조회
    public PagingResponse<BoardDTO> boardList(final BoardAPI api){

        int count = boardMapper.count(api);

        if(count < 1){
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, api);
        api.setPagination(pagination);

        List<BoardDTO> list = boardMapper.getList(api);
        return new PagingResponse<>(list, pagination);
    }

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

}
package com.farhan.staradmin.mapper;

import com.farhan.staradmin.domain.BoardAPI;
import com.farhan.staradmin.domain.BoardDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {

    int boardCount(BoardAPI api);

    BoardDTO getBoard(int id);

    List<BoardDTO> getList(BoardAPI api);

    void uploadBoard(BoardDTO board);

    void updateBoard(BoardDTO board);

    void deleteBoard(Long id);

}

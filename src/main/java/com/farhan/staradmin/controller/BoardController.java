package com.farhan.staradmin.controller;

import com.farhan.staradmin.domain.BoardDTO;
import com.farhan.staradmin.domain.BoardAPI;
import com.farhan.staradmin.domain.PagingResponse;
import com.farhan.staradmin.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "pages")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "board")
    public ModelMap boardlist(@ModelAttribute("api") BoardAPI api, Model model){
        ModelMap modelMap = new ModelMap();
        PagingResponse<BoardDTO> response = boardService.boardList(api);
        model.addAttribute("list", this.boardService.boardList(api));
        return modelMap;
    }

    @GetMapping(value = "boardview")
    public ModelMap boardview(Integer id){
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("boardview", this.boardService.getBoard(id));
        return modelMap;
    }

    @GetMapping(value = "boardupload")
    public ModelMap boardupload(){
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("board", new BoardDTO());
        return modelMap;
    }

    @PostMapping(value = "boardupload")
    public String pboardupload(@ModelAttribute("board") BoardDTO board){
        boardService.uploadBoard(board);
        return "redirect:board";
    }

    @PutMapping(value = "boardupdate")
    public String boardupdate(@ModelAttribute("board") BoardDTO board){
        boardService.updateBoard(board);
        return "redirect:board";
    }

    @DeleteMapping(value = "boarddelete")
    public String boarddelete(Long id){
        boardService.deleteBoard(id);
        return "redirect:board";
    }

//    @GetMapping(value = "user")
//    public ModelMap mmDashboard() {
//        // todo get apple stock price
//        ModelMap modelMap = new ModelMap();
//        model.addAttribute("cnt", boardService.boardCount());
//        model.addAttribute("test", boardService.boardList());
//        return modelMap;
//    }
}
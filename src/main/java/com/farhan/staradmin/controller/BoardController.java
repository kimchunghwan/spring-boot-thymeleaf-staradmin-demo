package com.farhan.staradmin.controller;

import com.farhan.staradmin.domain.BoardDTO;
import com.farhan.staradmin.model.UserSample;
import com.farhan.staradmin.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.ArrayList;


@Controller
@RequestMapping(value = "pages")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "board")
    public ModelMap boardlist(Model model){
        ModelMap modelMap = new ModelMap();
        model.addAttribute("cnt", this.boardService.boardCount());
        model.addAttribute("list", this.boardService.boardList());
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
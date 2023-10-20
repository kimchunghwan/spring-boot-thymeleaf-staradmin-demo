package com.farhan.staradmin.controller;

import com.farhan.staradmin.model.UserSample;
import com.farhan.staradmin.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.ArrayList;


@Controller
@RequestMapping(value = "pages")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "board")
    public ModelMap test(Model model){
        ModelMap modelMap = new ModelMap();
        model.addAttribute("cnt", this.boardService.boardCount());
        model.addAttribute("test", this.boardService.boardList());
        return modelMap;
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
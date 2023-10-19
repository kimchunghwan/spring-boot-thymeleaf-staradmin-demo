package com.farhan.staradmin.controller;  // 패키지 정보 추가

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.farhan.staradmin.model.UserSample;
import com.farhan.staradmin.service.UserSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pages")
public class UserSampleController {

    private static final Logger logger = LoggerFactory.getLogger(UserSampleController.class);  // Logger 객체 생성

    @Autowired
    private UserSampleService userSampleService;

    @GetMapping(value = "/user-sample-list")
    public String selectAllUsers(Model model, @RequestParam(required = false) Boolean updated) {
        List<UserSample> users = userSampleService.selectAllUsers();

        // 로깅 추가: 사용자 목록을 로그에 출력
        logger.info("Fetched users: {}", users);

        if (Boolean.TRUE.equals(updated)) {
            model.addAttribute("showPopup", true);
        }

        model.addAttribute("users", users);
        return "pages/user-sample-list";
    }

    @GetMapping("/user-sample-detail/{id}")
    public String selectOneUserById(@PathVariable Long id, Model model) {
        UserSample user = userSampleService.selectOneUserById(id);

        // 로깅 추가: 사용자 목록을 로그에 출력
        logger.info("Fetched user: {}", user);

        model.addAttribute("user", user);
        return "pages/user-sample-detail";
    }

    // insertUser

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("mailPrefix") String mailPrefix, @RequestParam("mailSuffix") String mailSuffix,  UserSample userSample, Model model) {
        // Mail
        String mail = mailPrefix + "@" + mailSuffix;
        userSample.setMail(mail);

        // UpdatedAt
        userSample.setUpdatedAt(new Date());

        userSampleService.updateUser(userSample);

        // 로깅 추가: 업데이트된 사용자 정보를 로그에 출력
        logger.info("Updated user: {}", userSample);

        model.addAttribute("showUpdatePopup", true);

        return "redirect:/pages/user-sample-list?updated=true";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable Long id, Model model) {
        userSampleService.deleteUserById(id);

        // 로깅 추가: 삭제된 사용자 정보를 로그에 출력
        logger.info("Deleted user: {}", id);

        model.addAttribute("showDeletePopup", true);

        // 삭제 완료 후 유저 리스트 페이지로 리다이렉트합니다.
        return "redirect:/pages/user-sample-list?deleted=true";
    }

}
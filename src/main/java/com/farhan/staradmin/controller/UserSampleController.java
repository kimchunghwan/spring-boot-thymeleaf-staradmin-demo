package com.farhan.staradmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.farhan.staradmin.model.UserSample;
import com.farhan.staradmin.service.UserSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pages")
public class UserSampleController {

    private static final Logger logger = LoggerFactory.getLogger(UserSampleController.class);

    @Autowired
    private UserSampleService userSampleService;

    @GetMapping("/user-sample-list")
    public String selectAllUsers(Model model) {
        List<UserSample> users = userSampleService.selectAllUsers();

        logger.info("Fetched users: {}", users);

        model.addAttribute("users", users);

        return "pages/user-sample-list";
    }

    @GetMapping("/user-sample-detail/{id}")
    public String selectOneUserById(@PathVariable Long id, Model model) {
        UserSample user = userSampleService.selectOneUserById(id);

        logger.info("Fetched user: {}", user);

        model.addAttribute("user", user);

        return "pages/user-sample-detail";
    }

    @PostMapping("/user-sample-detail/updateUser")
    public String updateUser(@RequestParam("familyName") String familyName, @RequestParam("firstName") String firstName, RedirectAttributes redirectAttributes, @RequestParam("mailPrefix") String mailPrefix, @RequestParam("mailSuffix") String mailSuffix, UserSample userSample) {
        // userName
        String fullName = familyName + " " + firstName;
        redirectAttributes.addFlashAttribute("userName", fullName);

        // Mail
        String mail = mailPrefix + "@" + mailSuffix;
        userSample.setMail(mail);

        // UpdatedAt
        userSample.setUpdatedAt(new Date());

        userSampleService.updateUser(userSample);

        logger.info("Updated user: {}", userSample);

        return "redirect:/pages/user-sample-list?updated=true";
    }

    @PostMapping("/user-sample-detail/quitUser/{id}")
    public String quitUserById(@RequestParam("familyName") String familyName, @RequestParam("firstName") String firstName, RedirectAttributes redirectAttributes, @PathVariable Long id) {
        // userName
        String fullName = familyName + " " + firstName;
        redirectAttributes.addFlashAttribute("userName", fullName);

        userSampleService.quitUserById(id);

        logger.info("Quit user: {}", id);

        return "redirect:/pages/user-sample-list?quit=true";
    }

    @GetMapping("/user-sample-input")
    public String createUserForm() {
        return "pages/user-sample-input";
    }

    @PostMapping("/user-sample-input/createUser")
    public String createUser(@RequestParam("familyName") String familyName, @RequestParam("firstName") String firstName, RedirectAttributes redirectAttributes, @RequestParam("mailPrefix") String mailPrefix, @RequestParam("mailSuffix") String mailSuffix,  UserSample userSample) {
        // userName
        String fullName = familyName + " " + firstName;
        redirectAttributes.addFlashAttribute("userName", fullName);

        // Mail
        String mail = mailPrefix + "@" + mailSuffix;
        userSample.setMail(mail);

        // CreatedAt, UpdatedAt
        userSample.setCreatedAt(new Date());
        userSample.setUpdatedAt(new Date());

        userSampleService.createUser(userSample);

        logger.info("Created new user: {}", userSample);

        return "redirect:/pages/user-sample-list?created=true";
    }
}
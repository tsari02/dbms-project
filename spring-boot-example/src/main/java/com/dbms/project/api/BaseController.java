package com.dbms.project.api;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    @GetMapping("/")
    public String index(Model model, String error, String logout, HttpSession session) {
//
//        System.out.println(session.getAttribute("loggedUser").toString());
//        if (authenticateService.isAuthenticated(session)) {
//            return "redirect:/welcome";
//        }
//        model.addAttribute("user", new User());

        return "dashboard";
    }
}

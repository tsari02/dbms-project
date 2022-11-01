package com.dbms.project.api;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, String error, String logout, HttpSession session) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
//
//        System.out.println(session.getAttribute("loggedUser").toString());
//        if (authenticateService.isAuthenticated(session)) {
//            return "redirect:/welcome";
//        }
//        model.addAttribute("user", new User());

        return "login";
    }
}

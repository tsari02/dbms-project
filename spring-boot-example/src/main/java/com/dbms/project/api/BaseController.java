package com.dbms.project.api;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        System.out.println(authentication);
        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.getAuthorities());

//
//        System.out.println(session.getAttribute("loggedUser").toString());
//        if (authenticateService.isAuthenticated(session)) {
//            return "redirect:/welcome";
//        }
//        model.addAttribute("user", new User());

        return "dashboard";
    }
}

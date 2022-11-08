package com.dbms.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dbms.project.model.Employee;
import com.dbms.project.service.EmployeeService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthenticationController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String login(Model model, String error, String logout, HttpSession session) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");


        return "login";
    }

    @GetMapping(path="/profile")
    public String profile() {
        return "profile";
    }

    @PostMapping(path = "/profile/edit")
    public String profileEditSubmit(@Valid @ModelAttribute("profile") Employee profile, RedirectAttributes redirectAttributes) {
        employeeService.updateEmployee(profile.getId(), profile);
        return "redirect:/profile";
    }

    @GetMapping(path="/profile/edit")
    public String profileEditForm() {
        return "profile-edit";
    }

    @GetMapping(path="/profile/password")
    public String profilePasswordForm() {
        return "profile-password";
    }

    @PostMapping(path="/profile/password")
    public String profilePasswordSubmit(@RequestParam("password") String password, RedirectAttributes redirectAttributes, Authentication authentication) {
        Employee profile = ((Employee) authentication.getPrincipal());
        System.out.println(profile);
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
        System.out.println(profile);
        employeeService.updatePassword(profile.getId(), profile);
        
        return "redirect:/profile";
    }
}

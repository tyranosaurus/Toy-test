package com.midasit.bungae.login.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/login")
public class LoginViewController {
    @GetMapping(path = "/loginForm")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping(path = "/logout")
    public String doLogout(HttpSession httpSession) {
        SecurityContextHolder.clearContext();
        httpSession.invalidate();

        return "redirect:/login/loginForm";
    }

    @GetMapping(path = "/joinForm")
    public String sowJoinForm() {
        return "join";
    }
}

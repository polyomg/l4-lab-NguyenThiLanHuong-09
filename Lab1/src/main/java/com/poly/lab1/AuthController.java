package com.poly.lab1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest; // nếu lỗi, đổi thành javax.servlet.http.HttpServletRequest

@Controller
public class AuthController {

    // Link: http://localhost:8080/login/form

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/login/form")
    public String form() {
        return "Lab1/form";
    }

    @PostMapping("/login/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Đăng nhập thành công");
        } else {
            model.addAttribute("message", "Đăng nhập thất bại");
        }

        return "Lab1/form";
    }
}

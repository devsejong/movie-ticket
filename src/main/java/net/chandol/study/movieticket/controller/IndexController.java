package net.chandol.study.movieticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("name", "세종");
        return "pages/index";
    }

}
package com.map.controller;

import com.map.model.mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/mail")
public class MailController {

    @GetMapping("/form")
    public String create(Model model) {
//        String language[] = {"Vietnamese","English","Japanese","Chinese"};
//        model.addAttribute("lisLanguages",language);
//        model.addAttribute("mail", new mail());
        return "/meo";
    }
}

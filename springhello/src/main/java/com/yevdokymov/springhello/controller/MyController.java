package com.yevdokymov.springhello.controller;

import com.yevdokymov.springhello.service.MarkService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MyController {
    MarkService markService;

    @PostMapping("hello")
    public String sayHello(@RequestParam(value = "username") String name, @RequestParam int mark, Model model) {
        model.addAttribute("name", name);
        String textMark = markService.calculate(mark);
        model.addAttribute("mark", textMark);
        return "hello";
    }
}

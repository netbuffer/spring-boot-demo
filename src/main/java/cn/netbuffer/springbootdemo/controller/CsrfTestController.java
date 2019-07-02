package cn.netbuffer.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/csrf")
public class CsrfTestController {

    @GetMapping
    public String get() {
        return "csrf-test";
    }

    @PostMapping
    public String post(String name, Model model) {
        log.info("receive name:{}", name);
        model.addAttribute("name", name);
        return "csrf-test";
    }
}

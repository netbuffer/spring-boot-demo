package cn.netbuffer.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping
    public String get() {
        return "view";
    }

    @GetMapping("inner")
    public String inner() {
        return "view";
    }

    @GetMapping("outter")
    public String outter() {
        return "view-outter";
    }
}

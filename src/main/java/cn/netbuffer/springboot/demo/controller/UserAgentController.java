package cn.netbuffer.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ua")
public class UserAgentController {

    @GetMapping
    public String ua(@RequestHeader("User-Agent") String userAgent) {
        return userAgent;
    }
}
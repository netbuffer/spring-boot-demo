package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DynamicHandler {

    public String test() {
        log.debug("test execute");
        return this.getClass().getSimpleName();
    }

}
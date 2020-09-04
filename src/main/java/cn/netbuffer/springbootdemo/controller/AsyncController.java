package cn.netbuffer.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {

    //get http://localhost:9100/async/error?errMessage=null-pointer
    @Async
    @GetMapping("error")
    public void errorTest(String errMessage) {
        log.debug("error test");
        throw new RuntimeException(errMessage);
    }
}

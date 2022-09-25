package cn.netbuffer.springboot.demo.controller;

import cn.netbuffer.springboot.demo.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Resource
    private TaskService taskService;

    //get http://localhost:9100/async/error?errMessage=null-pointer
    @Async
    @GetMapping("error")
    public void errorTest(String errMessage) {
        log.debug("error test");
        throw new RuntimeException(errMessage);
    }

    @Async
    @GetMapping("sleeptask")
    public void sleeptask(@RequestParam(value = "sleep", required = false) Integer sleep) {
        StopWatch stopWatch = new StopWatch("sleeptask");
        stopWatch.start();
        log.debug("do something");
        try {
            TimeUnit.SECONDS.sleep(sleep);
        } catch (InterruptedException e) {
            log.error("sleeptask error:", e);
        }
        stopWatch.stop();
        log.debug("sleeptask exec success cost total {}s\n{}", stopWatch.getTotalTimeSeconds(), stopWatch.prettyPrint());
    }

    @GetMapping("dotask")
    public void dotask(@RequestParam(value = "sleep", required = false) Integer sleep) {
        taskService.doSomething(sleep);
    }

}

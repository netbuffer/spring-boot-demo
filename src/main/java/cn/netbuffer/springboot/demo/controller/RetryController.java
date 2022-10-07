package cn.netbuffer.springboot.demo.controller;

import cn.netbuffer.springboot.demo.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/retry")
public class RetryController {

    @Resource
    private RetryService retryService;

    @GetMapping("test")
    public int test() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("retryService.test");
        int r = retryService.test();
        stopWatch.stop();
        log.debug("retryService.test cost {}ms\n", stopWatch.getTotalTimeMillis(), stopWatch.prettyPrint());
        return r;
    }

}
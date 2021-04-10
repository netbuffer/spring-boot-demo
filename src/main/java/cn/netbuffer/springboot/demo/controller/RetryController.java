package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/retry")
public class RetryController {

    @Retryable(maxAttempts = 3, label = "retry-test", value = RuntimeException.class)
    @GetMapping("test")
    public void test() {
        int r = (int) (Math.random() * 10);
        log.debug("random:{}", r);
        if (r > 5) {
            throw new RuntimeException("random number is " + r);
        }
    }
}

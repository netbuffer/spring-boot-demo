package cn.netbuffer.springboot.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetryService {

    @Retryable(maxAttempts = 3,
            label = "retry-test",
            value = RuntimeException.class,
            listeners = {"retryControllerRetryListener"},
            backoff = @Backoff(delay = 2000, multiplier = 2, maxDelay = 10000))
    public int test() {
        int r = (int) (Math.random() * 10);
        log.debug("random:{}", r);
        if (r > 0) {
            throw new RuntimeException("random number is " + r);
        }
        return r;
    }

    @Recover
    public int recoverTest(RuntimeException runtimeException) {
        log.warn("recoverTest...runtimeException={}", runtimeException.getMessage());
        return -1;
    }

}
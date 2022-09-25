package cn.netbuffer.springboot.demo.service;

import cn.netbuffer.springboot.demo.decorator.HttpTaskDecorator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class TaskService {

    @Async
    public void doSomething(Integer sleep) {
        Map context = (Map) HttpTaskDecorator.HTTPTASKDECORATOR_THREADLOCAL.get();
        log.debug("do task get context={}", context);
        StopWatch stopWatch = new StopWatch("doSomething");
        stopWatch.start();
        try {
            TimeUnit.SECONDS.sleep(sleep);
        } catch (InterruptedException e) {
            log.error("sleeptask error:", e);
        }
        stopWatch.stop();
        log.debug("do task exec success cost total {}s\n{}", stopWatch.getTotalTimeSeconds(), stopWatch.prettyPrint());
    }

}
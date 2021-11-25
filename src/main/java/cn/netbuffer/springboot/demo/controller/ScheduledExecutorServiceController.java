package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
@RestController
@RequestMapping("/scheduledExecutorService")
public class ScheduledExecutorServiceController {

    private ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(Thread.currentThread().getThreadGroup(), runnable, "define-thread-name");
        }
    });
    private Map<String, ScheduledFuture> tasks = new HashMap<>();

    @GetMapping("schedule")
    public boolean schedule(String task) {
        //shutdown后不能再调度任务
        ScheduledFuture scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.debug("schedule task[{}] execute", task);
            }
        }, 1, 3, TimeUnit.SECONDS);
        tasks.put(task, scheduledFuture);
        return scheduledFuture.isDone();
    }

    @GetMapping("schedule/cancel")
    public boolean scheduleCancel(String task) {
        ScheduledFuture scheduledFuture = tasks.get(task);
        boolean result = scheduledFuture.cancel(true);
        log.debug("cancel task[{}]:{}", task, result);
        return result;
    }

    @GetMapping("shutdown")
    public void shutdown() {
        log.debug("shutdown");
        scheduledExecutorService.shutdown();
    }

}

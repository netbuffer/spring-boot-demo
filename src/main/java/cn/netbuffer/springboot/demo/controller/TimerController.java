package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Slf4j
@RestController
@RequestMapping("/timer")
public class TimerController {

    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            log.debug("TimerTask schedule");
        }
    };
    private ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);

    @GetMapping("schedule")
    public void schedule() {
        //timer cancel后，无法再继续调度任务 timerTask实例被cancel后，也无法再继续调度任务
        timer.schedule(timerTask, 1000, 5000);
    }

    @GetMapping("cancel")
    public void cancel() {
        log.debug("timer cancel");
        timer.cancel();
    }

    @GetMapping("timerTask/cancel")
    public boolean timerTaskCancel() {
        return timerTask.cancel();
    }

}

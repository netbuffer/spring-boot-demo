package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@RestController
@RequestMapping("/timer")
public class TimerController {

    private Timer timer = new Timer();
    private Map<String, TimerTask> tasks = new HashMap<>();

    @GetMapping("schedule")
    public void schedule(String task) {
        //timer cancel后，无法再继续调度任务 timerTask实例被cancel后，也无法再继续调度任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                log.debug("TimerTask[{}] execute", task);
            }
        };
        tasks.put(task, timerTask);
        timer.schedule(timerTask, 1000, 5000);
    }

    @GetMapping("cancel")
    public void cancel() {
        log.debug("timer cancel");
        timer.cancel();
    }

    @GetMapping("timerTask/cancel")
    public boolean timerTaskCancel(String task) {
        TimerTask timerTask = tasks.get(task);
        boolean result = timerTask.cancel();
        log.debug("cancel TimerTask[{}]:{}", task, result);
        return result;
    }

}

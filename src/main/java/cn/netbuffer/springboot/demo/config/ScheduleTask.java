package cn.netbuffer.springboot.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
public class ScheduleTask {

    @Scheduled(cron = "0 0 */1 * * ?")
    public void print(){
        log.info("print task exec");
    }

}
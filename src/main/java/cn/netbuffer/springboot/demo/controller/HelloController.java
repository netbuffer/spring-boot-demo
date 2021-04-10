package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/")
public class HelloController {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @GetMapping(value = {"/", "hello"})
    public String hello(@RequestParam(value = "name", required = false) String name) {
        return "hello:" + name;
    }

    /**
     * 测试println对象锁占用阻塞
     *
     * @return
     */
    @GetMapping("println")
    public String println() {
        System.out.println("println");
        return "success:" + FORMAT.format(new Date());
    }

    @GetMapping("synchronized_system.out")
    @ResponseBody
    public String println(@RequestParam(value = "sleep",
            required = false, defaultValue = "10") Long sleep) {
        log.info("start");
        synchronized (System.out) {
            try {
                TimeUnit.SECONDS.sleep(sleep);
            } catch (InterruptedException e) {
                log.error("error:{}", e.getMessage());
            }
        }
        log.info("end");
        return sleep + "s :" + FORMAT.format(new Date());
    }

    /**
     * 从配置文件读取mapping映射
     * @return
     */
    @GetMapping("${req.mapping.user}")
    @ResponseBody
    public String reqMappingUser() {
        return "reqMappingUser";
    }

}
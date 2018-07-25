package cn.netbuffer.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/tl")
public class ThreadLocalController {

    private ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    @GetMapping
    public Object get(String key) {
        Object val = null;
        try {
            val = threadLocal.get().get(key);
        } catch (Exception e) {
            log.error("errmessage:", e);
        }
        log.info("get key:{},value:{}", key, val);
        return val;
    }

    @PostMapping
    public void post(@RequestBody Map data, String key, String value) {
        log.info("data:{},key:{},value:{}", data, key, value);
        threadLocal.set(data);
    }
}

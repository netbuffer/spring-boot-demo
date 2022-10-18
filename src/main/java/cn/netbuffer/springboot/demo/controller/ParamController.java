package cn.netbuffer.springboot.demo.controller;

import cn.netbuffer.springboot.demo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/param")
public class ParamController {

    @Value("${var.random-int1}")
    private int randomInt1;
    @Value("${var.random-int2}")
    private int randomInt2;
    @Value("${var.random-int3}")
    private int randomInt3;
    @Value("${var.random-value}")
    private String randomValue;
    @Value("#{'${var.list}'.split(',')}")
    private List<String> varList;
    @Value("${var.map.name}")
    private String mapValue;

    @GetMapping("random-var")
    public Object getRandomVars(String r) {
        Object value = null;
        switch (r) {
            case "1":
                value = randomInt1;
                break;
            case "2":
                value = randomInt2;
                break;
            case "3":
                value = randomInt3;
                break;
            case "4":
                value = randomValue;
                break;
            default:
                value = randomValue;
        }
        return value;
    }

    /**
     * 前端不传id参数500，传递非long类型数据400
     *
     * @param id
     * @return
     */
    @GetMapping
    public long get(long id) {
        log.info("id:{}", id);
        return id;
    }

    @GetMapping("var-list")
    public List<String> getVarList() {
        log.info("id:{}", varList);
        return varList;
    }

    @GetMapping("long")
    public Long getLong(Long id) {
        log.info("id:{}", id);
        return id;
    }

    //error
    @GetMapping("long/basic-type")
    public long getLong(@RequestParam(value = "id", required = false) long id) {
        log.info("id:{}", id);
        return id;
    }

    @GetMapping("str1")
    public String str1(String str1) {
        log.info("str1:{}", str1);
        return str1;
    }

    @GetMapping("str2")
    public String str2(@RequestParam("str2") String str2) {
        log.info("str2:{}", str2);
        return str2;
    }

    @GetMapping("str3")
    public String str3(@RequestParam(value = "str3", required = false) String str3) {
        log.info("str3:{}", str3);
        return str3;
    }

    /**
     * 测试结果默认接收jdk日期格式,输出的时区为格林尼治，+8个小时为中国时区
     * http://localhost:9100/param/date?date=Fri, 13 Dec 2019 09:19:10 GMT
     */
    @GetMapping(value = "date", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Date date(Date date) {
        log.info("date:{}", date);
        return date;
    }

    @PostMapping(value = "user", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User user(@RequestBody User user,HttpServletRequest httpServletRequest) {
        log.info("receive user:{}", user);
        ContentCachingRequestWrapper contentCachingRequestWrapper=WebUtils.getNativeRequest(httpServletRequest, ContentCachingRequestWrapper.class);
        //重复读取http body
        log.debug("http request body:{}", new String(contentCachingRequestWrapper.getContentAsByteArray()));
        return user;
    }

    @GetMapping(value = "test-stop-watch")
    public String testStopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch("test-stop-watch");
        stopWatch.start("calc1");
        TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
        stopWatch.stop();
        stopWatch.start("calc2");
        TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
        stopWatch.stop();
        String print = stopWatch.prettyPrint();
        log.info(print);
        return print;
    }

    @GetMapping(value = "task")
    public String task(@RequestParam(value = "time", defaultValue = "10") Integer time) {
        log.debug("start task");
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            log.error("task interrupt");
        }
        log.debug("end task");
        return "ok";
    }

    @GetMapping("mapValue")
    public Object mapValue() {
        return mapValue;
    }

    @Value("${data.name:null}")
    private String dataName;

    @GetMapping("dataName")
    public Object dataName() {
        return dataName;
    }

    @GetMapping("defaultValue")
    public String defaultValue(@RequestParam(defaultValue = "default") String value) {
        return value;
    }

}
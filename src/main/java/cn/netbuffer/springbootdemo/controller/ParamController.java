package cn.netbuffer.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
     * 默认jdk日期格式
     * http://localhost:9100/param/date?date=Fri, 13 Dec 2019 09:19:10 GMT
     */
    @GetMapping("date")
    public Date date(Date date) {
        log.info("date:{}", date);
        return date;
    }
}
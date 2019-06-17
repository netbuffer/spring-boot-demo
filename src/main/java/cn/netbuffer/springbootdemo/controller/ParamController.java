package cn.netbuffer.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/param")
public class ParamController {

    /**
     * 前端不传id参数500，传递非long类型数据400
     * @param id
     * @return
     */
    @GetMapping
    @ResponseBody
    public long get(long id){
        log.info("id:{}",id);
        return id;
    }

    @GetMapping("long")
    @ResponseBody
    public Long getLong(Long id){
        log.info("id:{}",id);
        return id;
    }

    @GetMapping("str1")
    @ResponseBody
    public String str1(String str1){
        log.info("str1:{}",str1);
        return str1;
    }

    @GetMapping("str2")
    @ResponseBody
    public String str2(@RequestParam("str2") String str2){
        log.info("str2:{}",str2);
        return str2;
    }

    @GetMapping("str3")
    @ResponseBody
    public String str3(@RequestParam(value = "str3",required = false) String str3){
        log.info("str3:{}",str3);
        return str3;
    }
}
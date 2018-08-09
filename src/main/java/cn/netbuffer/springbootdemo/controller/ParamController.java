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
        return id;
    }
}
package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//extends ResponseEntityExceptionHandler for Override Specified exception
@Slf4j
@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler
    @ResponseBody
    public Object handleAllException(Exception e, HandlerMethod handlerMethod, HttpMethod httpMethod, HttpServletRequest httpServletRequest) {
        log.error("{} to {} processed by {} error:{}", httpMethod.name(), httpServletRequest.getRequestURI(), handlerMethod.getMethod(), e.getMessage());
        Map data = new HashMap(2);
        data.put("status", false);
        data.put("msg", e.getMessage());
        data.put("processed-by", this.getClass().getSimpleName());
        return data;
    }

}

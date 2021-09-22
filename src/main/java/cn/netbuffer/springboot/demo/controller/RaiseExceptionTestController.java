package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/raise/exception/test")
public class RaiseExceptionTestController {

    @GetMapping("long")
    public Long get(Long id) {
        return id;
    }

    /**
     * controller内部ExceptionHandler优先级高于ControllerAdvice中设置的ExceptionHandler
     * @param e
     * @param handlerMethod
     * @param httpMethod
     * @param httpServletRequest
     * @return
     */
//    @ExceptionHandler
//    @ResponseBody
//    public Object handleException(Exception e, HandlerMethod handlerMethod, HttpMethod httpMethod, HttpServletRequest httpServletRequest) {
//        log.error("{} to {} processed by {} error:{}", httpMethod.name(), httpServletRequest.getRequestURI(), handlerMethod.getMethod(), e.getMessage());
//        Map data = new HashMap(2);
//        data.put("status", false);
//        data.put("msg", e.getMessage());
//        data.put("random", Math.random());
//        data.put("processed-by", this.getClass().getSimpleName());
//        return data;
//    }
}

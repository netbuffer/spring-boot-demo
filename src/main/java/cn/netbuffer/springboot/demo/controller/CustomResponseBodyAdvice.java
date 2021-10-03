package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import java.util.Map;

@Slf4j
//@ControllerAdvice
public class CustomResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        Class targetClass = methodParameter.getMethod().getDeclaringClass();
        log.debug("supports execute methodParameter={} targetClass={} class={}", methodParameter, targetClass, aClass);
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.debug("beforeBodyWrite data={}", data);
        if (serverHttpRequest.getURI().getPath().equals("/ua")) {
            serverHttpResponse.getHeaders().set("x-abc", "header-value");
        }
        if (data instanceof String) {
            return "[" + data + "]";
        } else if (data instanceof Map) {
            ((Map) data).put("extData", "value");
            return data;
        } else {
            return data;
        }
    }

}

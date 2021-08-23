package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/mapping")
public class RequestMappingController {

    @Resource
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping
    public void allMapping() {
        Map<RequestMappingInfo, HandlerMethod> mappings = requestMappingHandlerMapping.getHandlerMethods();
        log.debug("mappings size:{}", mappings.size());
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : mappings.entrySet()) {
            log.debug("key:{},value:{}", entry.getKey(), entry.getValue());
            log.debug("path:{}", entry.getKey().getDirectPaths());
        }
    }
}

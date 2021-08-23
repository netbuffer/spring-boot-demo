package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
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
    @Resource
    private ApplicationContext applicationContext;

    @GetMapping
    public void allMapping() {
        Map<RequestMappingInfo, HandlerMethod> mappings = requestMappingHandlerMapping.getHandlerMethods();
        log.debug("mappings size:{}", mappings.size());
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : mappings.entrySet()) {
            log.debug("key:{},value:{}", entry.getKey(), entry.getValue());
            log.debug("path:{}", entry.getKey().getDirectPaths());
        }
    }

    @PostMapping("registerMapping")
    public RequestMappingInfo registerMapping(@RequestBody Map data) {
        RequestMappingInfo mappingInfo = RequestMappingInfo.paths(data.get("path").toString()).build();
        Object bean = applicationContext.getBean(data.get("bean").toString());
        try {
            requestMappingHandlerMapping.registerMapping(mappingInfo, bean, bean.getClass().getDeclaredMethod(data.get("method").toString(), null));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return mappingInfo;
    }

    @PostMapping("unregisterMapping")
    public RequestMappingInfo unregisterMapping(@RequestBody Map data) {
        RequestMappingInfo mappingInfo = RequestMappingInfo.paths(data.get("path").toString()).build();
        requestMappingHandlerMapping.unregisterMapping(mappingInfo);
        return mappingInfo;
    }
}

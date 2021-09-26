package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/mapping")
public class RequestMappingController {

    @Resource
    private RequestMappingHandlerMapping requestMappingHandlerMapping;
    @Resource
    private ApplicationContext applicationContext;

    /**
     *
     * @return
     */
    @RequestMapping("api/**")
    public Object api() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        HttpServletResponse httpServletResponse = servletRequestAttributes.getResponse();
        return httpServletRequest.getRequestURI();
    }

    @GetMapping("allMapping")
    public void allMapping() {
        Map<RequestMappingInfo, HandlerMethod> mappings = requestMappingHandlerMapping.getHandlerMethods();
        log.debug("mappings size:{}", mappings.size());
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : mappings.entrySet()) {
            log.debug("key:{},value:{}", entry.getKey(), entry.getValue());
            log.debug("path:{}", entry.getKey().getDirectPaths());
        }
    }

    /**
     * 动态注册路径映射
     *
     * @param data
     * @return
     */
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

    /**
     * 动态删除路径映射
     *
     * @param data
     * @return
     */
    @PostMapping("unregisterMapping")
    public RequestMappingInfo unregisterMapping(@RequestBody Map data) {
        RequestMappingInfo mappingInfo = RequestMappingInfo.paths(data.get("path").toString()).build();
        requestMappingHandlerMapping.unregisterMapping(mappingInfo);
        return mappingInfo;
    }
}

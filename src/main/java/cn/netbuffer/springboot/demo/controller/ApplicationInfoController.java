package cn.netbuffer.springboot.demo.controller;

import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/application/info")
public class ApplicationInfoController {

    @Resource
    private ApplicationContext applicationContext;
    private String gitProperties = "git.properties";

    @GetMapping
    public String info() {
        org.springframework.core.io.Resource resource = applicationContext.getResource("classpath:"+gitProperties);
        log.debug("check {} isExist={}", gitProperties, resource.exists());
        String info = "nothing";
        if (resource.exists()) {
            try {
                info = IOUtils.toString(resource.getInputStream());
            } catch (IOException e) {
                info = "error info";
                log.error("read {} error", gitProperties, e);
            }
        }
        return info;
    }

}
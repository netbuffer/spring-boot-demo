package cn.netbuffer.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

@Slf4j
@RestController
@RequestMapping("/servlet-context")
public class ServletContextController {

    @Resource
    private ServletContext servletContext;

    @GetMapping("context-path")
    public String getContextPath() {
        return servletContext.getContextPath();
    }

    @GetMapping("server-info")
    public String getServerInfo() {
        return servletContext.getServerInfo();
    }

    @GetMapping("virtual-server-name")
    public String getVirtualServerName() {
        return servletContext.getVirtualServerName();
    }

}

package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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

    @GetMapping("session-timeout")
    public int getSessionTimeout(HttpSession httpSession) {
        return httpSession.getMaxInactiveInterval();
    }

}

package cn.netbuffer.springboot.demo.decorator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskDecorator;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HttpTaskDecorator implements TaskDecorator {

    public static final ThreadLocal HTTPTASKDECORATOR_THREADLOCAL = new ThreadLocal();

    @Override
    public Runnable decorate(Runnable runnable) {
        log.debug("decorate async task runnable={}", runnable);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userAgent = request.getHeader("user-agent");
        log.debug("decorate async task get user-agent={}", userAgent);
        Map context = new HashMap<>();
        context.put("userAgent", userAgent);
        return new Runnable() {
            @Override
            public void run() {
                log.info("set thread context={}", context);
                try {
                    HTTPTASKDECORATOR_THREADLOCAL.set(context);
                    runnable.run();
                } catch (Exception e) {
                    log.error("async task error:", e);
                } finally {
                    HTTPTASKDECORATOR_THREADLOCAL.remove();
                }
            }
        };
    }

}
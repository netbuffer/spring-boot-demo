package cn.netbuffer.springboot.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        log.debug("invoke method[{}] args:{} error:{}", method.getDeclaringClass().getName() + "." + method.getName(), Arrays.deepToString(obj), throwable.getMessage());
    }

}
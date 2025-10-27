package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * test page:https://github.com/netbuffer/UItest/blob/master/es/eventsource.html
 */
@Slf4j
@RestController
@RequestMapping("/sse")
public class SSEController {

    private Map<String, SseEmitter> sseEmitterMap = new HashMap<>();

    //https://www.w3.org/TR/eventsource/
    @GetMapping(path = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin
    public SseEmitter handle(String id) {
        log.debug("new SseEmitter for id={}", id);
        SseEmitter sseEmitter = new SseEmitter(30 * 1000L);

        // 添加超时和完成回调
        sseEmitter.onTimeout(() -> {
            log.debug("SseEmitter timeout for id={}", id);
            sseEmitterMap.remove(id);
        });

        sseEmitter.onCompletion(() -> {
            log.debug("SseEmitter completed for id={}", id);
            sseEmitterMap.remove(id);
        });

        sseEmitter.onError((e) -> {
            log.error("SseEmitter error for id={}: {}", id, e.getMessage());
            sseEmitterMap.remove(id);
        });

        try {
            // 发送初始事件
            sseEmitter.send(SseEmitter.event().name("init").data("Connection established"));
        } catch (IOException e) {
            log.error("Failed to send initial event", e);
        }

        sseEmitterMap.put(id, sseEmitter);
        return sseEmitter;
    }

    @RequestMapping("sendById")
    public void sendById(String id, String message) throws IOException {
        log.debug("send message with SseEmitter id={}", id);
        SseEmitter emitter = sseEmitterMap.get(id);
        if (emitter != null) {
            emitter.send(SseEmitter.event().data(message,MediaType.TEXT_PLAIN));
        }
    }

}
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
        sseEmitterMap.put(id, sseEmitter);
        return sseEmitter;
    }

    @GetMapping("sendById")
    public void sendById(String id, String message) throws IOException {
        log.debug("send message with SseEmitter id={}", id);
        sseEmitterMap.get(id).send(message);
    }

}
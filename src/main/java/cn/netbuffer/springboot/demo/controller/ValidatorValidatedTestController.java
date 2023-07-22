package cn.netbuffer.springboot.demo.controller;

import cn.netbuffer.springboot.demo.annotation.ValidBigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Slf4j
@Validated
@RestController
@RequestMapping("/validator/validated")
public class ValidatorValidatedTestController {


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@NotBlank(message = "用户名不能为空") String username,
                                               @Size(min = 6, message = "密码长度不能少于6位") String password) {
        log.debug("receive username={} password={}", username, password);
        return ResponseEntity.ok("注册成功-" + username);
    }

    @GetMapping("/calculate")
    public ResponseEntity<BigDecimal> calculate(@ValidBigDecimal(message = "b1格式非法") String b1,
                                                @Size(min = 6, message = "b2格式非法") String b2) {
        log.debug("receive b1={} b2={}", b1, b2);
        return ResponseEntity.ok(new BigDecimal(b1).add(new BigDecimal(b2)));
    }

}
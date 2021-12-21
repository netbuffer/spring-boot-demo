package cn.netbuffer.springboot.demo.controller;

import cn.netbuffer.springboot.demo.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/validator")
public class ValidatorTestController {

    @Resource
    private ValidatorFactory validatorFactory;
    @Resource
    private Validator validator;

    @GetMapping("getValidatorFactory")
    public String getValidatorFactory() {
        return validatorFactory.toString();
    }

    @GetMapping("getValidator")
    public String getValidator() {
        return validator.toString();
    }

    @GetMapping("validateUser")
    public boolean validateUser(User user) {
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        log.debug("validate user={} result={}", user, constraintViolations);
        return constraintViolations.size() > 0 ? false : true;
    }

    @GetMapping("user")
    public @Valid User user(@Valid User user) {
        return user;
    }

}
package cn.netbuffer.springboot.demo.validator;

import cn.netbuffer.springboot.demo.annotation.ValidBigDecimal;
import org.springframework.util.StringUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class BigDecimalValidator implements ConstraintValidator<ValidBigDecimal, String> {

    @Override
    public void initialize(ValidBigDecimal constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtils.hasText(value)) {
            return false;
        }
        try {
            new BigDecimal(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
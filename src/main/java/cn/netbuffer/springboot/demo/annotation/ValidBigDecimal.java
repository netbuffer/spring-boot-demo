package cn.netbuffer.springboot.demo.annotation;

import cn.netbuffer.springboot.demo.validator.BigDecimalValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BigDecimalValidator.class)
public @interface ValidBigDecimal {

    String message() default "Invalid BigDecimal format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
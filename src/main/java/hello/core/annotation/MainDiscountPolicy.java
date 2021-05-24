package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
//중요하다.
@Qualifier("mainDiscountPolicy")
//MainDiscountPolicy 애노테이션을 쓰면 위에있는게/
//전부다 동작한다.
public @interface MainDiscountPolicy {

}

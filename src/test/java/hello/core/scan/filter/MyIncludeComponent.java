package hello.core.scan.filter;

import java.lang.annotation.*;

//직접 Annotation을 만들어 해당 Annotation이 붙어 있으면 bean으로 등록한다.

// type 은 클래스에 붙음.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}

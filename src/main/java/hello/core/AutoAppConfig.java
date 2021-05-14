package hello.core;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 설정 어노테이션지정
@Configuration

// 자동으로 스캔하여 bean에 등록
// filter를 이용하여 제외 가능
// 해당 필터는 이전에 만들어둔 AppConfig에 있는 Configration을 제외시킨다.
// 그렇지 않으면 충돌 발생함
@ComponentScan(
        //basePackages를 주면 해당 위치 부터 탐색함.
        // 이렇게 되면 member만 뒤진다.
        basePackages = "hello.core.member",
        // 해당 클래스가 있는 패키지를 뒤진다.
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

public class AutoAppConfig {

}
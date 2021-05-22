package hello.core.lombok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class modelConfig {

    @Bean
    public Model2 model2() {
        return new Model2();
    }

    @Bean
    public Model model() {
        return new Model(model2());
    }
}

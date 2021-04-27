package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationContextInfo {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name =" + beanDefinitionName + "bean = " + bean);
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames){
            //Object bean = ac.getBean(beanDefinitionName);
            //System.out.println("name =" + beanDefinitionName + "bean = " + bean);

            //bean 하나의 메타 definition을 가져온다.
             BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
             
             // 내가 어플리케이션을 개발하려고 등록한 빈들만 출력
             if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                 Object bean = ac.getBean(beanDefinitionName);
                 System.out.println("name =" + beanDefinitionName + "bean = " + bean);
             }
        }
    }
}

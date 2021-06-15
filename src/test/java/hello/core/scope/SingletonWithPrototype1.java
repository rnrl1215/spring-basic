package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototype1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);


        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(2);
    }

    // ClientBean 은 싱글톤
    @Scope("singleton")
    static class ClientBean {
       /*
        // 생성시점에 주입 그래서 계속 같은걸 쓴다.
        // 처음 주입때만 생성한다.
        // private final PrototypeBean prototypeBean;

        @Autowired
        ApplicationContext ac;

        // 이때 PrototypeBean을 요청하고 찾는다.
        // 이미 생성시점에 만들어 진 애를 사용한다.
        @Autowired
        public  ClientBean(PrototypeBean prototypeBean) {
           this.prototypeBean = prototypeBean;
        }

        public int logic() {
            // 여기가 핵심이다. 그냥 부를때 마다 빈을 가져온다.
            // 그렇게 되면 프로토타입의 동작을 제대로 한다.
            PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
        */


        /*
        @Autowired
        //private ObjectProvider<PrototypeBean> prototypeBeanProvider;  //방법1
        private ObjectFactory<PrototypeBean> prototypeBeanProvider;     //방법2

        public int logic() {
            // 항상 새로운 타입의 프로토타입이 생성됨.
            PrototypeBean prototypeBean =  prototypeBeanProvider.getObject();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
   */

        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;     //방법2

        public int logic() {
            // 항상 새로운 타입의 프로토타입이 생성됨.
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }

    }

}

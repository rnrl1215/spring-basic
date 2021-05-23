package hello.core.lombok;
/*
// 롬복을 적용하지 않은 코드
public class hello.core.lombok.Model {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
*/

/*
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 롭롬복 적용
public class hello.core.lombok.Model {

    private String id;
    private String name;

    public static void main(String[] args) {
        hello.core.lombok.Model model = new hello.core.lombok.Model();
        model.setName("TEST");
        System.out.println(model.getName());
    }
}
*/

/*
import lombok.Data;

@Data
public class hello.core.lombok.Model {

    private String id;
    private String name;

    public static void main(String[] args) {
        hello.core.lombok.Model model = new hello.core.lombok.Model();
        model.setName("TEST");
        System.out.println(model.getName());
    }
}
*/



// 주입성 까지 롬복으로 간소화
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class hello.core.lombok.Model {

    private String id;
    private String name;
    private final hello.core.lombok.Model2 model2;

    @Autowired
    public hello.core.lombok.Model(hello.core.lombok.Model2 modle2){
        this.model2 = modle2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(hello.core.lombok.modelConfig.class);

        hello.core.lombok.Model model = ac.getBean("model", hello.core.lombok.Model.class);
        model.setName("TEST2");
        System.out.println(model.getName());
    }
}
*/

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Data
public class Model {

    private String id;
    private String name;
    private final Model2 model2;

    /*
    @Autowired
    public hello.core.lombok.Model(hello.core.lombok.Model2 modle2){
        this.model2 = modle2;
    }
    */

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(com.skahn.lombok.modelConfig.class);

        Model model = ac.getBean("model", Model.class);
        model.setName("TEST23");
        System.out.println(model.getName());
    }
}
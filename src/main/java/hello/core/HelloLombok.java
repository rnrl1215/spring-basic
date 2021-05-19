package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// lombok이 자동으로 만들어줌.
// get, set을 만들어 주지 않도됨.
@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(22);
        helloLombok.setName("gogogo");

        String name = helloLombok.getName();
        int age = helloLombok.getAge();

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        System.out.println("helloLombok = " + helloLombok);
    }
}

import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {

        String name = null;


        if (name != null) {
            System.out.println("is not null");
        } else {
            System.out.println("is null");
        }


        if (Optional.ofNullable(name).isPresent()) {
            System.out.println("is not null");
        } else {
            System.out.println("is null");
        }


        String name2 = "test";
        Optional.ofNullable(name2).ifPresent(
                name3->System.out.println(name3)
                );


        List<String> list=List.of("test!","test!!","test!!!","item!!!!");
        list.stream()
                .filter(s ->s.length() == 5)
                .findAny()
                .ifPresent( s-> System.out.println(s) );
    }
}

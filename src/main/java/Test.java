import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.github.javafaker.Faker;
public class Test {
    public static void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
        Faker faker = new Faker(new Locale("vi"));

        for (int i = 0; i < 1000; i++) {
            //Fake thong tin
            Human human = new Human();
            human.setId(i);
            human.setFirstname(faker.name().firstName());
            human.setLastname(faker.name().lastName());
            human.setCity(faker.address.);
        }

    }
}

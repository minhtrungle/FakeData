import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.github.javafaker.Faker;
public class Test {
    public static <Faker> void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
        Faker faker = new Faker(new Locale("vi"));

        for (int i = 0; i < 1000; i++) {
            //Fake thong tin
            Human human = new Human();
            human.setId(i);
            human.setFirstname(faker.name().firstName());
            human.setLastname(faker.name().lastName());
            human.setCity(faker.address().cityName());
            human.setGender(faker.number().numberBetween(0, 2));
            human.setAge(faker.number().numberBetween(10,51));
            human.setSalary(faker.number().numberBetween(10,3001));
            // Them vao humanList
            humanList.add(human);
        }

        humanList.stream().forEach(p-> System.out.println(p));

    }
}

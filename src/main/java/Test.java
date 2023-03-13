import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;
import com.github.javafaker.Faker;
public class Test {
    public static void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
        Faker faker = new Faker(new Locale("vi"));

        for (int i = 0; i < 1000; i++) {
            //Fake thông tin
            Human human = new Human();
            human.setId(i);
            human.setFirstname(faker.name().firstName());
            human.setLastname(faker.name().lastName());
            human.setCity(faker.address().cityName());
            human.setGender(faker.number().numberBetween(0, 2));
            human.setAge(faker.number().numberBetween(10,51));
            human.setSalary(faker.number().numberBetween(10,3001));
            //Thêm vào humanList
            humanList.add(human);
        }

        humanList.stream().forEach(p-> System.out.println(p));

        //Có bao nhiêu nam trên 18 tuổi
        long count = humanList.stream().filter(human -> (human.getGender() == 1 && human.getAge() > 18)).count();
        System.out.println("Số người trên 18 tuổi là: " + count);


        //Có bao nhiêu nữ có tên đệm “thị”
        long count1 = humanList.stream()
                .filter(human -> (human.getGender() == 0 && human.getFullName().contains("thị"))).count();
        System.out.println("Số người là nữ có tên đệm “thị” " + count1);

        //Lọc ra những người họ “Nguyễn” và sắp xếp theo thứ tự chữ cái
        humanList.stream()
                .filter(human -> human.getLastname().equalsIgnoreCase("Nguyễn"))
                .sorted()
                .forEach(human -> System.out.println(human));

        //In ra danh sách những người độ tuổi từ 20-30
        System.out.println("Danh sách những người độ tuổi từ 20-30");
        humanList.stream()
                .filter(human -> human.getAge() >= 20 && human.getAge() <=30)
                .forEach(human -> System.out.println(human));

        //Đếm số lượng thành phố có trong danh sách trên. (gợi ý: distinct)
        long count2 = humanList.stream()
//                .map(new Function<Human, String>() {
//                    @Override
//                    public String apply(Human human) {
//                        return human.getCity();
//                    }
//                })
                .map(human -> human.getCity())
                .distinct()//duy nhất
                .count();
        System.out.printf("Có tất cả %d thành phố \n", count2);

        //Lấy ra 10 người đầu tiên trong danh sách
        humanList.stream()
                .limit(10)
                .forEach(human -> System.out.println(human));

        //Tính độ tuổi trung bình.
        System.out.printf("Độ tuổi trung bình");
        final double[] tongTuoi = {0};
        humanList.stream()
                .forEach(human -> {
                    tongTuoi[0] = tongTuoi[0] + human.getAge();
                });
        System.out.println("Trung bình tuổi: " + tongTuoi[0] / humanList.size());

        //Tính mức lương trung bình của nam ở độ tuổi từ 20-40
        System.out.println("Mức lương trung bình của nam ở độ tuổi từ 20-40");
        final double[] tongLuong = {0};
        final int[] soNguoi = {0};

        humanList.stream()
                .filter(human -> human.getAge() >= 20 && human.getAge() <= 40)
                .forEach(human -> {
                    tongLuong[0] = tongLuong[0] + human.getSalary();
                    soNguoi[0] ++;
                });
        System.out.println("Trung bình lương" + tongLuong[0] / soNguoi[0]);

        //Sắp xếp danh sách theo độ tuổi.
        System.out.println("Sắp xếp danh sách theo độ tuổi.\n");
        humanList.stream()
//                .sorted(new Comparator<Human>() {
//                    @Override
//                    public int compare(Human o1, Human o2) {
//                        if (o1.getAge() > o2.getAge()) {
//                            return 1;
//                        } else if (o1.getAge() < o2.getAge()) {
//                            return -1;
//                        }
//                        return 0;
//                    }
//                })
                .sorted((o1, o2) -> {
                    if (o1.getAge() > o2.getAge()) {
                        return 1;
                    } else if (o1.getAge() < o2.getAge()) {
                        return -1;
                    }
                    return 0;
                })
                .forEach(human -> System.out.println(human));

        //In ra danh sách theo City – List<Human>
        humanList.stream()
                .map(human -> human.getCity())
                .distinct();
    }
}

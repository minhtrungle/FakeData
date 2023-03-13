public class Human {
    private int id;
    private String firstname;
    private String lastname;
    private String city;
    private int gender;  // 0: nu, 1:nam
    private int age;
    private int salary;

    public Human() {
    }

    public Human(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Human(int id, String firstname, String lastname, String city, int gender, int age, int salary) {
        if (age < 0 || salary < 0) {
            throw new RuntimeException("Error");
        }
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new RuntimeException("Error");
        }
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new RuntimeException("Error");
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Human[" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ']';
    }
}

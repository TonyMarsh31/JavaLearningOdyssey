package myreflect4getField;

public class Student {

    public String name;

    private final int money = 300;

    public String gender;
    public int age = 10;


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", money=" + money +
                '}';
    }
}

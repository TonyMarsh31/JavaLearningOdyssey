package methodsReference;

public class Employee {
    private String sex;
    private Integer id;

    public Employee(String s, int i) {
        this.sex = s;
        this.id = i;
    }

    public Employee() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

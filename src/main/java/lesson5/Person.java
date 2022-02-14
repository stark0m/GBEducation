package lesson5;

public class Person {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.setAge(age);
    }

    @Override
    public String toString() {
        return String.format("%s, %d лет", fullName, age);
    }

    public void aboutMe() {
        System.out.println();
        System.out.printf("Имя: %s%n", fullName);
        if (this.getAge() % 10 < 5 && this.getAge() % 10 > 0) {
            System.out.printf("Возраст: %d года%n", age);
        } else {
            System.out.printf("Возраст: %d лет%n", age);
        }

        System.out.println("Телефон: " + this.getPhone());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Должность: " + this.getPosition());
        System.out.println("Оклад: " + this.getSalary());

    }

    public Person(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.setPosition(position);
        this.setEmail(email);
        this.setPhone(phone);
        this.setSalary(salary);
        this.setAge(age);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
}

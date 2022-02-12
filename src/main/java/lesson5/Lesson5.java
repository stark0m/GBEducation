package lesson5;

public class Lesson5 {
    public static final int AGE_TO_CHECK = 40;

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89316472713", 30000, 50);
        persArray[1] = new Person("Safronov Mihail", "HR manager", "mihail@gmail.com", "8921641649", 70000, 39);
        persArray[2] = new Person("Davidov Dmitry", "Student", "davidov@main.com", "894826152", 90000, 44);
        persArray[3] = new Person("Lomakin Oleg", "Programmer", "OlegL@yahoo.com", "892317433", 110000, 47);
        persArray[4] = new Person("Petrov Petr", "Driver", "Ppetr98@mail.ru", "892315235", 650000, 26);
        for (Person person : persArray) {
            if (person.getAge() > 40) {
                person.aboutMe();

            }
        }

    }
}

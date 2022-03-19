package Lesson11;

import java.math.BigInteger;


public class SecondTask {
    public static void main(String[] args) {
        PhoneBook peoplePhoneBook = new PhoneBook();

        peoplePhoneBook.add("Smirnov", BigInteger.valueOf(524346343));
        peoplePhoneBook.add("Smirnov", BigInteger.valueOf(524352364));
        peoplePhoneBook.add("Ivanov", BigInteger.valueOf(524346346));
        peoplePhoneBook.add("Petrov", BigInteger.valueOf(523646343));
        peoplePhoneBook.add("Gusev", BigInteger.valueOf(854446343));
        peoplePhoneBook.add("Mironov", BigInteger.valueOf(126746343));
        peoplePhoneBook.add("Gusev", BigInteger.valueOf(765446343));

        System.out.println(peoplePhoneBook.get("Mironov"));
        System.out.println(peoplePhoneBook.get("Smirnov"));
        System.out.println(peoplePhoneBook.get("Agatov"));
        System.out.println(peoplePhoneBook);



    }


}

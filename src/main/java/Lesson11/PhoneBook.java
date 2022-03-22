package Lesson11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;


public class PhoneBook {
    HashMap<String, Book> phones = new HashMap<>();

    public void add(String name,BigInteger phone){
        if (phones.containsKey(name)){
            phones.get(name).phoneNumbers.add(phone);
        } else {
            Book newBook = new Book();
            newBook.phoneNumbers.add(phone);
            phones.put(name, newBook);
        }
    }


    @Override
    public String toString() {
        return "PhoneBook = "+ phones ;
    }

    public String get(String name) {
        if (phones.containsKey(name)){
            return name + " телефоны " +
            phones.get(name).phoneNumbers;
        } else {return "Телефонных номеров с фамилией " + name + " не найдено";
        }

    }

    private class Book{
        ArrayList<BigInteger> phoneNumbers = new ArrayList<>();

        @Override
        public String toString() {
            return phoneNumbers.toString();
        }
    }
}

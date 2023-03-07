package ru.netology;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook(new HashMap<>());

        Contact mary = new Contact("Mary", "12345");
        Contact ann = new Contact("Ann", "7899");
        Contact pavel = new Contact("Pavel", "25665");


        book.addGroup("Work");
        book.addGroup("Friends");

        book.addContact(mary, new String[]{"Work", "Friends"});
        book.addContact(ann, "Work");
        book.addContact(pavel, "Friends");
        book.deleteContact(mary);

        book.print();
        System.out.println();
        System.out.println("Кнтакты группы Work\n" + book.foundGroup("Work"));
        System.out.println();
        System.out.println(book.foundContact("12345"));
        System.out.println(book.foundContact("7899"));
        System.out.println(book.foundContact("7899888"));

    }
}
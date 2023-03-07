package ru.netology;

import java.util.Objects;

public class Contact {
    private final String name;
    private final String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        Contact cont = (Contact) obj;
        return name.equals(cont.name);
    }

    @Override
    public String toString() {
        return name + " - " + number;
    }

}
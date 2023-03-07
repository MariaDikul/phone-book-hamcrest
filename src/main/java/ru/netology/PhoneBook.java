package ru.netology;

import java.util.*;

public class PhoneBook {
    Map<String, List<Contact>> book;

    public PhoneBook(Map<String, List<Contact>> book) {
        this.book = book;
    }

    public Map<String, List<Contact>> addGroup(String groupName) {
        book.put(groupName, new ArrayList<>());
        return book;
    }

    public Map<String, List<Contact>> addContact(Contact contact, String groupName) {
        book.get(groupName).add(contact);
        return book;
    }

    public Map<String, List<Contact>> addContact(Contact contact, String[] groups) {
        for (String group : groups) {
            addContact(contact, group);
        }
        return book;
    }

    public Map<String, List<Contact>> deleteContact(Contact contact) {
        for (List<Contact> group : book.values()) {
            Iterator<Contact> iterator = group.iterator();
            while (iterator.hasNext()) {
                Contact e = iterator.next();
                if (e == contact) {
                    iterator.remove();
                }
            }
        }
        return book;
    }

    public List<Contact> foundGroup(String groupName) {
        List<Contact> contactOfGroup = new ArrayList<>();
        Iterator<Contact> it = book.get(groupName).iterator();
        while (it.hasNext()) {
            contactOfGroup.add(it.next());
        }
        return contactOfGroup;

    }

    public Contact foundContact(String number) {
        Contact contact1 = new Contact(null, number);
        for (List<Contact> group : book.values()) {
            for (Contact contact : group) {
                if (contact.getNumber().equals(number)) {
                    contact1 = contact;
                }
            }
        }
        if (contact1.getName() != null) {
            return contact1;
        } else {
            return new Contact("Контакт ", "не найден");
        }
    }

    public void print() {
        for (String groupName : book.keySet()) {
            System.out.println("Группа " + groupName);
            for (Contact contact : book.get(groupName)) {
                System.out.println(contact);
            }
            System.out.println();
        }
    }
}

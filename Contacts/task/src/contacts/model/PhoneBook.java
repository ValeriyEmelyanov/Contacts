package contacts.model;

import contacts.view.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final List<Contact> contacts = new ArrayList<>();

    ConsoleHelper consoleHelper = ConsoleHelper.getInstance();

    public void add() {
        String name = consoleHelper.readName();
        String surname = consoleHelper.readSurname();
        String number = consoleHelper.readNumber();
        contacts.add(new Contact(name, surname, number));
        consoleHelper.showMessage("The record added.");
    }

    public void remove() {
        if (contacts.isEmpty()) {
            consoleHelper.showMessage("No records to remove!");
            return;
        }
        list();
        int record = consoleHelper.selectRecord();

        contacts.remove(record - 1);
        consoleHelper.showMessage("The record removed!");
    }

    public void edit() {
        if (contacts.isEmpty()) {
            consoleHelper.showMessage("No records to edit!");
            return;
        }
        list();
        int record = consoleHelper.selectRecord();
        Contact contact = contacts.get(record - 1);

        String field = consoleHelper.selectField();
        switch (field) {
            case "name":
                contact.setName(consoleHelper.readName());
                break;
            case "surname":
                contact.setSurname(consoleHelper.readSurname());
                break;
            case "number":
                contact.setNumber(consoleHelper.readNumber());
                break;
            default:
                consoleHelper.showMessage("Invalid input!");
                return;
        }
        consoleHelper.showMessage("The record updated!");
    }

    public void count() {
        consoleHelper.showMessage(String.format("The Phone Book has %d records.", contacts.size()));
    }

    public void list() {
        int counter = 0;
        for (Contact contact : contacts) {
            consoleHelper.showMessage(String.format("%d. %s", ++counter, contact));
        }
    }
}

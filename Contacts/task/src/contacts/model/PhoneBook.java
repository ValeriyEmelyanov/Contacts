package contacts.model;

import contacts.view.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final List<Contact> contacts = new ArrayList<>();

    ConsoleHelper consoleHelper = ConsoleHelper.getInstance();

    public void add() {
        String type = consoleHelper.readContactType();
        Contact contact = null;
        switch (type) {
            case "person":
                contact = PersonContact.builder()
                        .setName(consoleHelper.readName())
                        .setSurname(consoleHelper.readSurname())
                        .setBirthDate(consoleHelper.readBirthDate())
                        .setGender(consoleHelper.readGender())
                        .setNumber(consoleHelper.readNumber())
                        .build();
                break;
            case "organization":
                contact = OrganizationContact.builder()
                        .setName(consoleHelper.readOrganizationName())
                        .setAddress(consoleHelper.readAddress())
                        .setNumber(consoleHelper.readNumber())
                        .build();
                break;
            default:
                consoleHelper.showMessage("Invalid input!");
                return;
        }
        contacts.add(contact);
        consoleHelper.showMessage("The record added.\n");
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

        if (contact.isPerson) {
            editPersonContact((PersonContact) contact);
        } else {
            editOrganizationContact((OrganizationContact) contact);
        }
    }

    public void editPersonContact(PersonContact contact) {
        String field = consoleHelper.selectPersonContactField();
        switch (field) {
            case "name":
                contact.setName(consoleHelper.readName());
                break;
            case "surname":
                contact.setSurname(consoleHelper.readSurname());
                break;
            case "birth":
                contact.setBirthDate(consoleHelper.readBirthDate());
                break;
            case "gender":
                contact.setGender(consoleHelper.readGender());
                break;
            case "number":
                contact.setNumber(consoleHelper.readNumber());
                break;
            default:
                consoleHelper.showMessage("Invalid input!");
                return;
        }
        consoleHelper.showMessage("The record updated!\n");
    }

    private void editOrganizationContact(OrganizationContact contact) {
        String field = consoleHelper.selectOrganizationContactField();
        switch (field) {
            case "name":
                contact.setName(consoleHelper.readOrganizationName());
                break;
            case "address":
                contact.setAddress(consoleHelper.readAddress());
                break;
            case "number":
                contact.setNumber(consoleHelper.readNumber());
                break;
            default:
                consoleHelper.showMessage("Invalid input!");
                return;
        }
        consoleHelper.showMessage("The record updated!\n");
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

    public void info() {
        list();

        String strIndex = consoleHelper.readInfoIndex();
        if (strIndex == null || !strIndex.matches("\\d+")) {
            consoleHelper.showMessage("Invalid input!");
            return;
        }
        int index = Integer.parseInt(strIndex) - 1;
        if (index < 0 || index >= contacts.size()) {
            consoleHelper.showMessage("Invalid input!");
            return;
        }

        Contact contact = contacts.get(index);
        consoleHelper.showMessage(contact.info() + "\n");
    }
}

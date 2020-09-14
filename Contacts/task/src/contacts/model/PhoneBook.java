package contacts.model;

import contacts.utils.ContactFactory;
import contacts.utils.SerialisationUtils;
import contacts.view.ConsoleHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private final List<Contact> contacts;
    private final String fileName;

    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();

    public PhoneBook(String fileName) {
        this.fileName = fileName;
        if (isFileNameEmpty()) {
            contacts = new ArrayList<>();
        } else {
            contacts = SerialisationUtils.deserialize(fileName);
            consoleHelper.showMessage("open " + fileName + "\n");
        }
    }

    public void add() {
        String type = consoleHelper.readContactType();
        Contact contact = ContactFactory.newInstance(type);
        if (contact == null) {
            return;
        }

        contacts.add(contact);
        serialize();
        consoleHelper.showMessage("The record added.\n");
    }

    private void removeContact(Contact contact) {
        contacts.remove(contact);
        serialize();
        consoleHelper.showMessage("The record removed!\n");
    }

    private void editContact(Contact contact) {
        String[] fields = contact.getEditableFields();
        String field = consoleHelper.selectContactField(String.join(", ", fields));
        if (Arrays.stream(fields).noneMatch(e -> e.equals(field))) {
            consoleHelper.showMessageInvalidInput();
            consoleHelper.skipLine();
            return;
        }
        String value = consoleHelper.readField(contact.getFieldDescription(field));
        if (contact.setFieldValue(field, value)) {
            consoleHelper.showMessage("Saved\n" + contact.info() + "\n");
            serialize();
        }
    }

    public void count() {
        consoleHelper.showMessage(String.format("The Phone Book has %d records.\n", contacts.size()));
    }

    public void list() {
        consoleHelper.showlist(contacts);

        String action = consoleHelper.listdMenu();
        if (action.equals("back")) {
            consoleHelper.skipLine();
            return;
        }

        if (!action.matches("\\d+")) {
            consoleHelper.showMessageInvalidInput();
            return;
        }

        int resordNo = Integer.parseInt(action);
        if (resordNo > contacts.size()) {
            consoleHelper.showMessageInvalidInput();
            return;
        }

        Contact contact = contacts.get(resordNo - 1);
        consoleHelper.showMessage(contact.info() + "\n");
        record(contact);
    }

    public void search() {
        do {
            List<Contact> result = searchContacts();

            consoleHelper.showMessage(String.format("Found %d results:", result.size()));
            consoleHelper.showlist(result);

            String action = consoleHelper.searchMenu();
            switch (action) {
                case "again":
                    continue;
                case "back":
                    consoleHelper.showMessage("");
                    return;
                default:
                    if (!action.matches("\\d+")) {
                        consoleHelper.showMessageInvalidInput();
                        consoleHelper.skipLine();
                        continue;
                    }
                    int recordNo = Integer.parseInt(action);
                    if (recordNo > result.size()) {
                        consoleHelper.showMessageInvalidInput();
                        consoleHelper.skipLine();
                        continue;
                    }

                    Contact contact = result.get(recordNo - 1);
                    consoleHelper.showMessage(contact.info() + "\n");

                    record(contact);
                    return;
            }
        } while (true);
    }

    private List<Contact> searchContacts() {
        String query = consoleHelper.readSearchQuery();

        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            Matcher matcher = pattern.matcher(contact.searchInfo());
            if (matcher.find()) {
                result.add(contact);
            }
        }
        return result;
    }

    private void record(Contact contact) {
        while (true) {
            String action = consoleHelper.recordMenu();
            switch (action) {
                case "edit":
                    editContact(contact);
                    break;
                case "delete":
                    removeContact(contact);
                    return;
                case "menu":
                    consoleHelper.skipLine();
                    return;
                default:
                    consoleHelper.showMessageInvalidInput();
            }
        }
    }

    private boolean isFileNameEmpty() {
        return fileName == null || fileName.isEmpty();
    }

    private void serialize() {
        if (isFileNameEmpty()) {
            return;
        }
        SerialisationUtils.serialize(contacts, fileName);
    }

}

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
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final List<Contact> contacts;
    private final String fileName;

    public PhoneBook(String fileName) {
        this.fileName = fileName;
        if (isFileNameEmpty()) {
            contacts = new ArrayList<>();
        } else {
            contacts = SerialisationUtils.deserialize(fileName);
            consoleHelper.showMessage("open " + fileName + "\n");
        }
    }

    public List<Contact> getContacts() {
        return contacts;
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

    public void removeContact(Contact contact) {
        contacts.remove(contact);
        serialize();
        consoleHelper.showMessage("The record removed!\n");
    }

    public void editContact(Contact contact) {
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

    public List<Contact> searchContacts() {
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

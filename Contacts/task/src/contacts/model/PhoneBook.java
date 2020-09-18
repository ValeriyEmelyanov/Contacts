package contacts.model;

import contacts.utils.SerialisationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private final List<Contact> contacts;
    private final String fileName;

    public PhoneBook(String fileName) {
        this.fileName = fileName;
        if (isFileNameEmpty()) {
            contacts = new ArrayList<>();
        } else {
            contacts = SerialisationUtils.deserialize(fileName);
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void add(Contact contact) {
        contacts.add(contact);
        serialize();
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
        serialize();
    }

    public List<Contact> searchContacts(String query) {
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

    public boolean isFileNameEmpty() {
        return fileName == null || fileName.isEmpty();
    }

    public void serialize() {
        if (isFileNameEmpty()) {
            return;
        }
        SerialisationUtils.serialize(contacts, fileName);
    }

}

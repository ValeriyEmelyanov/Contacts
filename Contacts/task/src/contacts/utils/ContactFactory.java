package contacts.utils;

import contacts.model.Contact;
import contacts.model.OrganizationContact;
import contacts.model.PersonContact;
import contacts.view.ConsoleHelper;

public class ContactFactory {

    private static final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();

    public static Contact newInstance(String type) {
        switch (type) {
            case "person":
                return PersonContact.builder()
                        .setName(consoleHelper.readField("name"))
                        .setSurname(consoleHelper.readField("surname"))
                        .setBirthDate(consoleHelper.readField("birth date"))
                        .setGender(consoleHelper.readField("gender (M, F)"))
                        .setNumber(consoleHelper.readField("number"))
                        .build();
            case "organization":
                return OrganizationContact.builder()
                        .setName(consoleHelper.readField("organization name"))
                        .setAddress(consoleHelper.readField("address"))
                        .setNumber(consoleHelper.readField("number"))
                        .build();
            default:
                consoleHelper.showMessageInvalidInput();
                consoleHelper.skipLine();
                return null;
        }
    }

}

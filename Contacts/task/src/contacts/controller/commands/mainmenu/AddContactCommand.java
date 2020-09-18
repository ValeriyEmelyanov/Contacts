package contacts.controller.commands.mainmenu;

import contacts.controller.commands.Command;
import contacts.model.Contact;
import contacts.model.PhoneBook;
import contacts.utils.ContactFactory;
import contacts.view.ConsoleHelper;

public class AddContactCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook;

    public AddContactCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        String type = consoleHelper.readContactType();
        Contact contact = ContactFactory.newInstance(type);
        if (contact == null) {
            return;
        }

        phoneBook.add(contact);
        consoleHelper.showMessage("The record added.\n");
    }
}

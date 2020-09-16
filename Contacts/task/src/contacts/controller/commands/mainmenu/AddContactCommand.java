package contacts.controller.commands.mainmenu;

import contacts.controller.commands.Command;
import contacts.model.PhoneBook;

public class AddContactCommand implements Command {
    private final PhoneBook phoneBook;

    public AddContactCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.add();
    }
}

package contacts.controller.commands.mainmenu;

import contacts.controller.commands.Command;
import contacts.model.PhoneBook;

public class CountContactsCommand implements Command {
    private final PhoneBook phoneBook;

    public CountContactsCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.count();
    }
}

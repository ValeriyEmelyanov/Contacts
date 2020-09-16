package contacts.controller.commands.mainmenu;

import contacts.controller.commands.Command;
import contacts.model.PhoneBook;

public class ListContactsCommand implements Command {
    private final PhoneBook phoneBook;

    public ListContactsCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.list();
    }
}

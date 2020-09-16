package contacts.controller.commands.mainmenu;

import contacts.controller.commands.Command;
import contacts.model.PhoneBook;

public class SearchContactsCommand implements Command {
    private final PhoneBook phoneBook;

    public SearchContactsCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        phoneBook.search();
    }
}

package contacts.controller.commands.mainmenu;

import contacts.controller.commands.Command;
import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

public class CountCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook;

    public CountCommand(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void execute() {
        consoleHelper.showMessage(String.format("The Phone Book has %d records.\n", phoneBook.getContacts().size()));
    }
}

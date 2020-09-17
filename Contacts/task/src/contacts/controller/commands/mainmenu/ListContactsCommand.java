package contacts.controller.commands.mainmenu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

public class ListContactsCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook;
    private final Controller controller;

    public ListContactsCommand(PhoneBook phoneBook, Controller controller) {
        this.phoneBook = phoneBook;
        this.controller = controller;
    }

    @Override
    public void execute() {
        consoleHelper.showlist(phoneBook.getContacts());
        controller.pushMenu(controller.getListMenu());
    }
}

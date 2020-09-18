package contacts.controller.commands.recordmenu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.model.Contact;
import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

public class DeleteContactCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook;
    private final Controller controller;
    private final Contact contact;

    public DeleteContactCommand(PhoneBook phoneBook, Controller controller, Contact contact) {
        this.phoneBook = phoneBook;
        this.controller = controller;
        this.contact = contact;
    }

    @Override
    public void execute() {
        phoneBook.removeContact(contact);
        consoleHelper.showMessage("The record removed!\n");

        controller.popMenu();
        controller.popMenu();
    }
}

package contacts.controller.commands.listmenu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.controller.menu.RecordMenu;
import contacts.model.Contact;
import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

public class ContactInfoCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook;
    private final Controller controller;
    private final Contact contact;

    public ContactInfoCommand(PhoneBook phoneBook, Controller controller, Contact contact) {
        this.phoneBook = phoneBook;
        this.controller = controller;
        this.contact = contact;
    }

    @Override
    public void execute() {
        consoleHelper.showMessage(contact.info() + "\n");
        controller.pushMenu(new RecordMenu(phoneBook, controller, contact));
    }
}

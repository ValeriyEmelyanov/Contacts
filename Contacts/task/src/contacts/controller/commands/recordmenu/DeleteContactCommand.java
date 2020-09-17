package contacts.controller.commands.recordmenu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.model.Contact;
import contacts.model.PhoneBook;

public class DeleteContactCommand implements Command {
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
        controller.popMenu();
        controller.popMenu();
    }
}

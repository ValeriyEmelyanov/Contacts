package contacts.controller.commands.recordmenu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.model.Contact;
import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

import java.util.Arrays;

public class EditContactCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook;
    private final Controller controller;
    private final Contact contact;

    public EditContactCommand(PhoneBook phoneBook, Controller controller, Contact contact) {
        this.phoneBook = phoneBook;
        this.controller = controller;
        this.contact = contact;
    }

    @Override
    public void execute() {
        String[] fields = contact.getEditableFields();
        String field = consoleHelper.selectContactField(String.join(", ", fields));
        if (Arrays.stream(fields).noneMatch(e -> e.equals(field))) {
            consoleHelper.showMessageInvalidInput();
            consoleHelper.skipLine();
            return;
        }
        String value = consoleHelper.readField(contact.getFieldDescription(field));
        if (contact.setFieldValue(field, value)) {
            consoleHelper.showMessage("Saved\n" + contact.info() + "\n");
            phoneBook.serialize();
        }

        controller.popMenu();
        controller.popMenu();
    }
}

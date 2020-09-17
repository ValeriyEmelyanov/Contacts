package contacts.controller.menu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.controller.commands.listmenu.ContactInfoCommand;
import contacts.controller.commands.listmenu.ListBackCommand;
import contacts.model.Contact;
import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

public class ListMenu implements Menu {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final String prompt;
    private final PhoneBook phoneBook;
    private final Controller controller;
    private final Command backCommand;

    public ListMenu(PhoneBook phoneBook, Controller controller) {
        this.phoneBook = phoneBook;
        this.controller = controller;
        this.prompt = "\n[list] Enter action ([number], back): ";
        this.backCommand = new ListBackCommand(controller);
    }

    @Override
    public Command next() {
        while (true) {
            String action = consoleHelper.menu(prompt);
            if (action.equals("back")) {
                return backCommand;
            }

            if (!action.matches("\\d+")) {
                consoleHelper.showMessageInvalidInput();
                continue;
            }

            int resordNo = Integer.parseInt(action);
            if (resordNo > phoneBook.getContacts().size()) {
                consoleHelper.showMessageInvalidInput();
                continue;
            }

            Contact contact = phoneBook.getContacts().get(resordNo - 1);
            return new ContactInfoCommand(phoneBook, controller, contact);
        }
    }
}

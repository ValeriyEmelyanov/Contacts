package contacts.controller.menu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.controller.commands.common.BackCommand;
import contacts.controller.commands.common.InvalidInputCommand;
import contacts.controller.commands.listmenu.ContactInfoCommand;
import contacts.controller.commands.mainmenu.SearchCommand;
import contacts.model.Contact;
import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

import java.util.List;

public class SearchMenu implements Menu {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook;
    private final Controller controller;
    private final String prompt;
    private final List<Contact> searchResult;

    public SearchMenu(PhoneBook phoneBook, Controller controller, List<Contact> searchResult) {
        this.controller = controller;
        this.phoneBook = phoneBook;
        this.searchResult = searchResult;
        this.prompt = "[search] Enter action ([number], back, again): ";
    }

    @Override
    public Command next() {
        String action = consoleHelper.menu(prompt);

        if (action.equals("back")) {
            return new BackCommand(controller);
        }

        if (action.equals("again")) {
            controller.popMenu();
            return new SearchCommand(phoneBook, controller);
        }

        if (!action.matches("\\d+")) {
            return InvalidInputCommand.getInstance();
        }

        int recordNo = Integer.parseInt(action);
        if (recordNo > searchResult.size()) {
            return InvalidInputCommand.getInstance();
        }

        Contact contact = searchResult.get(recordNo - 1);
        return new ContactInfoCommand(phoneBook, controller, contact);
    }
}

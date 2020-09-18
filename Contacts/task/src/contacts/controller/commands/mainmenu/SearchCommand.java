package contacts.controller.commands.mainmenu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.controller.menu.SearchMenu;
import contacts.model.Contact;
import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

import java.util.List;

public class SearchCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook;
    private final Controller controller;

    public SearchCommand(PhoneBook phoneBook, Controller controller) {
        this.phoneBook = phoneBook;
        this.controller = controller;
    }

    @Override
    public void execute() {
        String query = consoleHelper.readSearchQuery();
        List<Contact> searchResult = phoneBook.searchContacts(query);

        consoleHelper.showMessage(String.format("Found %d results:", searchResult.size()));
        consoleHelper.showlist(searchResult);
        consoleHelper.skipLine();

        controller.pushMenu(new SearchMenu(phoneBook, controller, searchResult));
    }
}

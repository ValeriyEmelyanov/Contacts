package contacts.controller.menu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.controller.commands.InvalidInputCommand;
import contacts.controller.commands.mainmenu.AddContactCommand;
import contacts.controller.commands.mainmenu.CountContactsCommand;
import contacts.controller.commands.mainmenu.ExitCommand;
import contacts.controller.commands.mainmenu.ListContactsCommand;
import contacts.controller.commands.mainmenu.SearchContactsCommand;
import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

import java.util.HashMap;
import java.util.Map;

public class MainMenu implements Menu {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final String prompt;
    private final Map<String, Command> actions;

    public MainMenu(PhoneBook phoneBook, Controller controller) {
        this.prompt = "[menu] Enter action (add, list, search, count, exit): ";
        this.actions = new HashMap<>();
        this.actions.put("add", new AddContactCommand(phoneBook));
        this.actions.put("list", new ListContactsCommand(phoneBook, controller));
        this.actions.put("search", new SearchContactsCommand(phoneBook));
        this.actions.put("count", new CountContactsCommand(phoneBook));
        this.actions.put("exit", new ExitCommand(controller));
    }

    @Override
    public Command next() {
        Command command = actions.get(consoleHelper.menu(prompt));
        if (command == null) {
            return InvalidInputCommand.getInstance();
        }
        return command;
    }
}

package contacts.controller;

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
        prompt = "[menu] Enter action (add, list, search, count, exit): ";
        actions = new HashMap<>();
        actions.put("add", new AddContactCommand(phoneBook));
        actions.put("list", new ListContactsCommand(phoneBook));
        actions.put("search", new SearchContactsCommand(phoneBook));
        actions.put("count", new CountContactsCommand(phoneBook));
        actions.put("exit", new ExitCommand(controller));
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

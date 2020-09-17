package contacts.controller.menu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.controller.commands.InvalidInputCommand;
import contacts.controller.commands.mainmenu.AddContactCommand;
import contacts.controller.commands.recordmenu.DeleteContactCommand;
import contacts.controller.commands.recordmenu.EditContactCommand;
import contacts.controller.commands.recordmenu.RecordToMainMenuCommand;
import contacts.model.Contact;
import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

import java.util.HashMap;
import java.util.Map;

public class RecordMenu implements Menu {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final String prompt;
    private final Map<String, Command> actions;

    public RecordMenu(PhoneBook phoneBook, Controller controller, Contact contact) {
        this.prompt = "[record] Enter action (edit, delete, menu): ";
        this.actions = new HashMap<>();
        this.actions.put("edit", new EditContactCommand(phoneBook, controller, contact));
        this.actions.put("delete", new DeleteContactCommand(phoneBook,controller, contact));
        this.actions.put("menu", new RecordToMainMenuCommand(controller));
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

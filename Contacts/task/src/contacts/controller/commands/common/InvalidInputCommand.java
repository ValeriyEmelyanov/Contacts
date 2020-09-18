package contacts.controller.commands.common;

import contacts.controller.commands.Command;
import contacts.view.ConsoleHelper;

public class InvalidInputCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final static InvalidInputCommand instance = new InvalidInputCommand();

    private InvalidInputCommand() {
    }

    public static InvalidInputCommand getInstance() {
        return instance;
    }

    @Override
    public void execute() {
        consoleHelper.showMessageInvalidInput();
        consoleHelper.skipLine();
    }
}

package contacts.controller.commands.common;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.view.ConsoleHelper;

public class BackCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final Controller controller;

    public BackCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        consoleHelper.skipLine();
        controller.popMenu();
    }
}

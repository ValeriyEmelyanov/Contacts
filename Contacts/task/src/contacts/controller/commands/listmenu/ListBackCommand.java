package contacts.controller.commands.listmenu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.view.ConsoleHelper;

public class ListBackCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final Controller controller;

    public ListBackCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        consoleHelper.skipLine();
        controller.popMenu();
    }
}

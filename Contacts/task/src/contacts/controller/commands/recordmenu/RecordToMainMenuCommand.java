package contacts.controller.commands.recordmenu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;
import contacts.view.ConsoleHelper;

public class RecordToMainMenuCommand implements Command {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final Controller controller;

    public RecordToMainMenuCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        consoleHelper.skipLine();
        controller.popMenu();
        controller.popMenu();
    }
}

package contacts.controller.commands.mainmenu;

import contacts.controller.Controller;
import contacts.controller.commands.Command;

public class ExitCommand implements Command {
    private final Controller controller;

    public ExitCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.setExit(true);
    }
}

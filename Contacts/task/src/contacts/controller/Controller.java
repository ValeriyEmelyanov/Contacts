package contacts.controller;

import contacts.controller.commands.Command;
import contacts.model.PhoneBook;
import contacts.utils.Stack;
import contacts.view.ConsoleHelper;

public class Controller {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final Stack<Menu> stack;

    private boolean exit = false;

    public Controller(String fileName) {
        PhoneBook phoneBook = new PhoneBook(fileName);

        stack = new Stack<>();
        stack.push(new MainMenu(phoneBook, this));
    }

    public void run() {
        while (!exit) {
            Menu menu = stack.peek();
            Command command = menu.next();
            command.execute();
        }
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}

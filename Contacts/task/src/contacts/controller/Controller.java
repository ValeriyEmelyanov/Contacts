package contacts.controller;

import contacts.controller.commands.Command;
import contacts.controller.menu.ListMenu;
import contacts.controller.menu.MainMenu;
import contacts.controller.menu.Menu;
import contacts.model.PhoneBook;
import contacts.utils.Stack;
import contacts.view.ConsoleHelper;

public class Controller {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook;
    private final Stack<Menu> menuStack;

    private boolean exit = false;
    private Menu listMenu;

    public Controller(String fileName) {
        phoneBook = new PhoneBook(fileName);
        if (!phoneBook.isFileNameEmpty()) {
            consoleHelper.showMessage("open " + fileName + "\n");
        }

        menuStack = new Stack<>();
        menuStack.push(new MainMenu(phoneBook, this));
    }

    public void run() {
        while (!exit) {
            Menu menu = menuStack.peek();
            Command command = menu.next();
            command.execute();
        }
        consoleHelper.close();
    }

    public Menu getListMenu() {
        if (listMenu == null) {
            listMenu = new ListMenu(phoneBook, this);
        }
        return listMenu;
    }

    public void pushMenu(Menu menu) {
        menuStack.push(menu);
    }

    public void popMenu() {
        menuStack.pop();
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}

package contacts.controller;

import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

public class Controller {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook = new PhoneBook();

    public void run() {
        while (true) {
            String choice = consoleHelper.menu();
            switch (choice) {
                case "add":
                    phoneBook.add();
                    break;
                case "remove":
                    phoneBook.remove();
                    break;
                case "edit":
                    phoneBook.edit();
                    break;
                case "count":
                    phoneBook.count();
                    break;
                case "list":
                    phoneBook.list();
                    break;
                case "exit":
                    consoleHelper.close();
                    return;
                default:
                    consoleHelper.showMessage("Invalid input!");
            }
        }
    }
}

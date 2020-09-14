package contacts.controller;

import contacts.model.PhoneBook;
import contacts.view.ConsoleHelper;

public class Controller {
    private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
    private final PhoneBook phoneBook;

    public Controller(String fileName) {
        phoneBook = new PhoneBook(fileName);
    }

    public void run() {
        while (true) {
            String choice = consoleHelper.menu();
            switch (choice) {
                case "add":
                    phoneBook.add();
                    break;
                case "list":
                    phoneBook.list();
                    break;
                case "search":
                    phoneBook.search();
                    break;
                case "count":
                    phoneBook.count();
                    break;
                case "exit":
                    consoleHelper.close();
                    return;
                default:
                    consoleHelper.showMessageInvalidInput();
                    consoleHelper.skipLine();
            }
        }
    }
}

package contacts.view;

import contacts.model.Contact;

import java.util.List;
import java.util.Scanner;

public class ConsoleHelper {
    private static final ConsoleHelper INSTANCE = new ConsoleHelper();

    private ConsoleHelper() {
    }

    public static ConsoleHelper getInstance() {
        return INSTANCE;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void close() {
        scanner.close();
    }

    public String menu(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showMessageInvalidInput() {
        System.out.println("Invalid input!");
    }

    public void skipLine() {
        System.out.println();
    }

    public void showlist(List<Contact> contacts) {
        int counter = 0;
        for (Contact contact : contacts) {
            System.out.println(String.format("%d. %s", ++counter, contact));
        }
    }

    public String readContactType() {
        System.out.print("Enter the type (person, organization): ");
        return scanner.nextLine();
    }

    public String selectContactField(String fields) {
        System.out.printf("Select a field (%s): ", fields);
        return scanner.nextLine();
    }

    public String readField(String field) {
        System.out.printf("Enter %s: ", field);
        return scanner.nextLine();
    }

    public String readSearchQuery() {
        System.out.print("Enter search query: ");
        return scanner.nextLine();
    }

}

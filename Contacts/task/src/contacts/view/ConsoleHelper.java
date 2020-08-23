package contacts.view;

import java.util.Scanner;

public class ConsoleHelper {
    private static final ConsoleHelper INSTANCE = new ConsoleHelper();

    private ConsoleHelper() {
    }

    public static ConsoleHelper getInstance() {
        return INSTANCE;
    }

    private final Scanner scanner = new Scanner(System.in);

    public String menu() {
        System.out.print("Enter action (add, remove, edit, count, list, exit): ");
        return scanner.nextLine();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void close() {
        scanner.close();
    }

    public String readName() {
        System.out.print("Enter the name: ");
        return scanner.nextLine();
    }

    public String readSurname() {
        System.out.print("Enter the surname: ");
        return scanner.nextLine();
    }

    public String readNumber() {
        System.out.print("Enter the number: ");
        return scanner.nextLine();
    }

    public int selectRecord() {
        System.out.print("Select a record: ");
        String record = scanner.nextLine();
        return Integer.parseInt(record);
    }

    public String selectField() {
        System.out.print("Select a field (name, surname, number): ");
        return scanner.nextLine();
    }
}

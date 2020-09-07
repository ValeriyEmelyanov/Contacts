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
        System.out.print("Enter action (add, remove, edit, count, info, exit): ");
        return scanner.nextLine();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void close() {
        scanner.close();
    }

    public String readContactType() {
        System.out.print("Enter the type (person, organization): ");
        return scanner.nextLine();
    }

    public String readName() {
        System.out.print("Enter the name: ");
        return scanner.nextLine();
    }

    public String readSurname() {
        System.out.print("Enter the surname: ");
        return scanner.nextLine();
    }

    public String readBirthDate() {
        System.out.print("Enter the birth date: ");
        return scanner.nextLine();
    }

    public String readGender() {
        System.out.print("Enter the gender (M, F): ");
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

    public String selectPersonContactField() {
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        return scanner.nextLine();
    }

    public String readOrganizationName() {
        System.out.print("Enter the organization name: ");
        return scanner.nextLine();
    }

    public String readAddress() {
        System.out.print("Enter the address: ");
        return scanner.nextLine();
    }

    public String readInfoIndex() {
        System.out.print("Enter index to show info: ");
        return scanner.nextLine();
    }

    public String selectOrganizationContactField() {
        System.out.print("Select a field (name, address, number): ");
        return scanner.nextLine();
    }
}

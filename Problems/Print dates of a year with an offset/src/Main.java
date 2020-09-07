import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        final int offset = Integer.parseInt(scanner.nextLine());

        final int year = date.getYear();
        while (date.getYear() == year) {
            System.out.println(date);
            date = date.plusDays(offset);
        }
    }
}
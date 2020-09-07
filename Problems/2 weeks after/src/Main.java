import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        LocalDate result = LocalDate.parse(input).plusWeeks(2);

        System.out.println(result);
    }
}
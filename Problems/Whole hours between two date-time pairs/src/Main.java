import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime date1 = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime date2 = LocalDateTime.parse(scanner.nextLine());
        scanner.close();

        long result = date1.until(date2, ChronoUnit.HOURS);

        System.out.println(result);
    }
}
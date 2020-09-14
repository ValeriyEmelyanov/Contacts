import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int year = scanner.nextInt();
        final int dayOfYear = scanner.nextInt();
        scanner.close();

        LocalDate date = LocalDate.ofYearDay(year, dayOfYear);
        boolean result = date.getDayOfMonth() == 1;

        System.out.println(result);
    }
}
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int dayOfYear = scanner.nextInt();
        scanner.close();

        LocalDate date = LocalDate.ofYearDay(year, dayOfYear);

        boolean result = date.getDayOfMonth() == date.lengthOfMonth();

        System.out.println(result);
    }
}
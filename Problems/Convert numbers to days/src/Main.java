import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int day1 = scanner.nextInt();
        int day2 = scanner.nextInt();
        int day3 = scanner.nextInt();

        System.out.println(LocalDate.ofYearDay(year, day1));
        System.out.println(LocalDate.ofYearDay(year, day2));
        System.out.println(LocalDate.ofYearDay(year, day3));
    }
}
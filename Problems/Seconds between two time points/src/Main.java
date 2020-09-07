import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalTime time1 = LocalTime.parse(scanner.nextLine());
        final LocalTime time2 = LocalTime.parse(scanner.nextLine());
        scanner.close();

        int sec = Math.abs(time1.toSecondOfDay() - time2.toSecondOfDay());

        System.out.println(sec);
    }
}
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        scanner.close();

        final LocalTime time = LocalTime.parse(input);

        System.out.println(time.withSecond(0));
    }
}
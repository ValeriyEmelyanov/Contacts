import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final long sec = scanner.nextInt();
        scanner.close();

        LocalTime time = LocalTime.ofSecondOfDay(sec);

        System.out.println(time);
    }
}
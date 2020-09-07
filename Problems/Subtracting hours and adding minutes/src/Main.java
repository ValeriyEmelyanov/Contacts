import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
        String[] inputs = scanner.nextLine().split("\\s+");
        scanner.close();

        LocalDateTime result = date
                .minusHours(Integer.parseInt(inputs[0]))
                .plusMinutes(Integer.parseInt(inputs[1]));

        System.out.println(result);
    }
}
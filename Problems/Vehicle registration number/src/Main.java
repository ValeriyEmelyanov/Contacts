import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String regNum = scanner.nextLine(); // a valid or invalid registration number
        scanner.close();

        String regnumRegex = "[ABEKMHOPCTYX]\\d{3}[ABEKMHOPCTYX]{2}";
        boolean result = regNum.matches(regnumRegex);

        System.out.println(result);
    }
}
import java.util.Scanner;

class RemoveExtraSpacesProblem {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String text = scanner.nextLine();

        scanner.close();

        String result = text
                .replaceFirst("^\\s+", "")
                .replaceAll("\\s+$", "")
                .replaceAll("\\s+", " ");

        System.out.println(result);
    }
}
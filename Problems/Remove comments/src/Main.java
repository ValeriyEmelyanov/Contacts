import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String codeWithComments = scanner.nextLine();

        String result = codeWithComments
                .replaceAll("/\\*.*?\\*/", "")
                .replaceAll("//.*$", "");

        System.out.println(result);
    }
}
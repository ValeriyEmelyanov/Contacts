import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String stringWithHtmlTags = scanner.nextLine();
        scanner.close();

        //String result = stringWithHtmlTags.replaceAll("<[^<>]+>", "");
        String result = stringWithHtmlTags.replaceAll("<.+?>", "");

        System.out.println(result);
    }
}
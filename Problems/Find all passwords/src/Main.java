import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("password[:\\s]*([a-z0-9]+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        boolean isResult = false;
        while (matcher.find()) {
            isResult = true;
            System.out.println(matcher.group(1));
        }

        if (!isResult) {
            System.out.println("No passwords found.");
        }
    }
}
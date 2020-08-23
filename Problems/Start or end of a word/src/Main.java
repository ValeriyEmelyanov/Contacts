import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();
        scanner.close();

        Pattern pattern = Pattern.compile(String.format("(\\b%s)|(%s\\b)", part, part), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        boolean result = matcher.find();

        System.out.println(result ? "YES" : "NO");
    }
}
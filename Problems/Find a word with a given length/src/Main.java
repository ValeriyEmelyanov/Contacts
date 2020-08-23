import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile(String.format("\\b[a-zA-Z]{%d}\\b", size));
        Matcher matcher = pattern.matcher(line);

        boolean result = matcher.find();

        System.out.println(result ? "YES" : "NO");
    }
}
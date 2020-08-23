import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String imput = scanner.nextLine();
        scanner.close();

        String ipNum = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String rerex = String.format("^%s\\.%s\\.%s\\.%s$", ipNum, ipNum, ipNum, ipNum);

        boolean result = imput.matches(rerex);

        System.out.println(result ? "YES" : "NO");
    }
}
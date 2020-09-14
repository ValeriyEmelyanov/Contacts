package contacts;

import contacts.controller.Controller;

public class Main {
    public static void main(String[] args) {
        String fileName = null;
        if (args.length > 0) {
            fileName = args[0];
        }

        new Controller(fileName).run();
    }
}

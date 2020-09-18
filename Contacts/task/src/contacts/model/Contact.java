package contacts.model;

import contacts.view.ConsoleHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Contact {
    protected String number = "";
    private final LocalDateTime created;
    protected LocalDateTime lastEdit;

    protected final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();

    public Contact() {
        created = LocalDateTime.now();
        lastEdit = created;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = validNumber(number, consoleHelper);
        lastEdit = LocalDateTime.now();
    }

    public boolean hasNumber() {
        return number != null && !number.isEmpty();
    }

    private static boolean isNumberValid(String number, ConsoleHelper consoleHelper) {
        if (number == null || !number.matches("\\+?" +
                "(\\([\\da-zA-Z]{1,}\\)|[\\da-zA-Z]{1,}([ -]\\([\\da-zA-Z]{2,}+\\))?)" +
                "([ -][\\da-zA-Z]{2,})*")) {
            consoleHelper.showMessage("Wrong number format!");
            return false;
        }
        return true;
    }

    protected static String validNumber(String number, ConsoleHelper consoleHelper) {
        return isNumberValid(number, consoleHelper) ? number : "";
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public String info() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return String.format(
                "Number: %s\n" +
                "Time created: %s\n" +
                "Time last edit: %s",
                hasNumber() ? number : "[no number]",
                formatter.format(created),
                formatter.format(lastEdit));
    }

    public abstract String[] getEditableFields();

    public abstract String getFieldDescription(String field);

    public abstract boolean setFieldValue(String field, String value);

    public abstract String searchInfo();
}

package contacts.model;

import contacts.view.ConsoleHelper;

public class Contact {
    private String name;
    private String surname;
    private String number = "";

    ConsoleHelper consoleHelper = ConsoleHelper.getInstance();

    public Contact() {
    }

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        setNumber(number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = isNumberValid(number) ? number : "";
    }

    public boolean hasNumber() {
        return number != null && !number.isEmpty();
    }

    private boolean isNumberValid(String number) {
        if (number == null || !number.matches("\\+?" +
                "(([\\da-zA-Z]{1,}([ -]\\([\\da-zA-Z]{2,}\\))?)|(\\([\\da-zA-Z]{1,}\\)([ -][\\da-zA-Z]{2,})?))" +
                "([ -][\\da-zA-Z]{2,})*")) {
            consoleHelper.showMessage("Wrong number format!");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s",
                name,
                surname,
                hasNumber() ? number : "[no number]");
    }
}

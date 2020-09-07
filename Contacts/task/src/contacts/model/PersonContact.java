package contacts.model;

import contacts.view.ConsoleHelper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonContact extends Contact {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender = "";

    private PersonContact(String number, String name, String surname, LocalDate birthDate, String gender) {
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.isPerson = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.lastEdit = LocalDateTime.now();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        this.lastEdit = LocalDateTime.now();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = validBirthDate(birthDate, consoleHelper);
        this.lastEdit = LocalDateTime.now();
    }

    private static LocalDate validBirthDate(String birthDate, ConsoleHelper consoleHelper) {
        if (birthDate == null || birthDate.isEmpty()) {
            consoleHelper.showMessage("Bad birth date!");
            return null;
        }

        try {
            return LocalDate.parse(birthDate);
        } catch (Exception e) {
            consoleHelper.showMessage("Bad birth date!");
            return null;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = validGender(gender, consoleHelper);
        this.lastEdit = LocalDateTime.now();
    }

    private static boolean isGenderValid(String gender, ConsoleHelper consoleHelper) {
        if (gender == null || gender.isEmpty() || !gender.matches("[MF]")) {
            consoleHelper.showMessage("Bad gender!");
            return false;
        }
        return true;
    }

    private static String validGender(String gender, ConsoleHelper consoleHelper) {
        return isGenderValid(gender, consoleHelper) ? gender : "";
    }

    @Override
    public String info() {
        return String.format("Name: %s\n" +
                        "Surname: %s\n" +
                        "Birth date: %s\n" +
                        "Gender: %s\n",
                name,
                surname,
                birthDate != null ? birthDate : "[no data]",
                gender != null && !gender.isEmpty() ? gender : "[no data]") +
                super.info();
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private String number = "";
        private String name;
        private String surname;
        private LocalDate birthDate;
        private String gender = "";

        private final ConsoleHelper consoleHelper = ConsoleHelper.getInstance();

        Builder() {
        }

        public Builder setNumber(String number) {
            this.number = validNumber(number, consoleHelper);
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.birthDate = validBirthDate(birthDate, consoleHelper);
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = validGender(gender, consoleHelper);
            return this;
        }

        public PersonContact build() {
            return new PersonContact(number, name, surname, birthDate, gender);
        }
    }
}

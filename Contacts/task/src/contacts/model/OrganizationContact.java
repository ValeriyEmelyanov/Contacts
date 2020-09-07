package contacts.model;

import contacts.view.ConsoleHelper;

import java.time.LocalDateTime;

public class OrganizationContact extends Contact {
    private String name;
    private String address;

    private OrganizationContact(String number, String name, String address) {
        this.number = number;
        this.name = name;
        this.address = address;
        this.isPerson = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.lastEdit = LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.lastEdit = LocalDateTime.now();
    }

    @Override
    public String info() {
        return String.format("Organization name: %s\n" +
                        "Address: %s\n",
                name,
                address) +
                super.info();
    }

    @Override
    public String toString() {
        return name;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private String number = "";
        private String name;
        private String address;

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

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public OrganizationContact build() {
            return new OrganizationContact(number, name, address);
        }
    }
}

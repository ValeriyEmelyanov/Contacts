package contacts.model;

import contacts.view.ConsoleHelper;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OrganizationContact extends Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name = "";
    private String address = "";

    private OrganizationContact(String number, String name, String address) {
        this.number = number;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
        this.lastEdit = LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? "" : address;
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
    public String[] getEditableFields() {
        return new String[] {"name", "address", "number"};
    }

    @Override
    public String searchInfo() {
        return String.join(" ", super.searchInfo(), name, address);
    }

    @Override
    public String getFieldDescription(String field) {
        //if (field.equals("name")) {
        //    return "organization name";
        //}
        return field;
    }

    @Override
    public boolean setFieldValue(String field, String value) {
        switch (field) {
            case "name":
                setName(value);
                break;
            case "address":
                setAddress(value);
                break;
            case "number":
                setNumber(value);
                break;
            default:
                consoleHelper.showMessage("Invalid field name!");
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
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

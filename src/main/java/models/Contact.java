package models;

public class Contact {
    String name;
    String lastName;
    String phone;
    String  email;
    String address;
    String description;

    public Contact withName(String name) {
        this.name = name;
        return this;
    }

    public Contact withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact withEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact withAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
}

package org.example;

public class Client {
    private int id;
    private String name;
    private boolean businessPerson;
    private Person contactPerson;

    private Address address;

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", businessPerson=" + businessPerson +
                ", contactPerson=" + contactPerson +
                ", address=" + address +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBusinessPerson() {
        return businessPerson;
    }

    public void setBusinessPerson(boolean businessPerson) {
        this.businessPerson = businessPerson;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }
}

package org.example;

public class Enterprise {
    private int id;
    private String name;
    private boolean legalPerson;
    private Address address;
    private BankDetails bankDetails;
    private Person contactPerson;
    private String website;
    private String registerNr;
    private String refisterPlace;
    private String headOfEnterprise;
    private String email;
    private String phoneNr;
    private String ustId;
    public Enterprise() {
    }

    public String getUstId() {
        return ustId;
    }

    public void setUstId(String ustId) {
        this.ustId = ustId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRegisterNr() {
        return registerNr;
    }

    public void setRegisterNr(String registerNr) {
        this.registerNr = registerNr;
    }

    public String getRefisterPlace() {
        return refisterPlace;
    }

    public void setRefisterPlace(String refisterPlace) {
        this.refisterPlace = refisterPlace;
    }

    public String getHeadOfEnterprise() {
        return headOfEnterprise;
    }

    public void setHeadOfEnterprise(String headOfEnterprise) {
        this.headOfEnterprise = headOfEnterprise;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", legalPerson=" + legalPerson +
                ", address=" + address +
                ", bankDetails=" + bankDetails +
                ", contactPerson=" + contactPerson +
                ", website='" + website + '\'' +
                ", registerNr='" + registerNr + '\'' +
                ", refisterPlace='" + refisterPlace + '\'' +
                ", headOfEnterprise='" + headOfEnterprise + '\'' +
                ", email='" + email + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", ustId='" + ustId + '\'' +
                '}';
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

    public boolean isLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(boolean legalPerson) {
        this.legalPerson = legalPerson;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }
}

package org.example;

public class BankDetails {
    private int id;
    private String contoOwnerName;
    private String bankName;
    private String iban;
    private String bic;

    public BankDetails() {
    }

    @Override
    public String toString() {
        return "BankDetails{" +
                "id=" + id +
                ", contoOwnerName='" + contoOwnerName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContoOwnerName() {
        return contoOwnerName;
    }

    public void setContoOwnerName(String contoOwnerName) {
        this.contoOwnerName = contoOwnerName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}

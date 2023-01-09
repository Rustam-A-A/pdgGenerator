package org.example;

public class Taxes {
    private int id;
    private String taxName;
    private float taxRate;

    public Taxes() {
    }

    @Override
    public String toString() {
        return "Taxes{" +
                "id=" + id +
                ", taxName='" + taxName + '\'' +
                ", taxRate=" + taxRate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }
}

package CIT_242final;

import java.text.NumberFormat;

public class Product {

    private String code;
    private String id;
    private String description;
    private int amount;
    private double price;
    private char discount;
    private String madein;
    private String fabric;

    public Product() {
        this("", "", "", 0, 0, ' ',"","");
    }

    public Product( String code,String id, String description, int amount, double price, 
    					char discount, String madein, String fabric) 
    {
        this.code = code;
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.discount = discount;
        this.madein=madein;
        this.fabric=fabric;
    }

   

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
 public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    } 
   public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getAmountString() {
        String amountString = Integer.toString(amount);
        return amountString;

    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getFormattedPrice() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }

    public void setDiscount(char discount) {
        this.discount = discount;
    }

    public char getDiscount() {
        return discount;
    }
    
    public String getMadein() {
        return madein;
    }

    public void setMadein(String name) {
        this.madein = madein;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String type) {
        this.fabric = fabric;
    }

    public boolean equals(Object object) {
        if (object instanceof Product) {
            Product product2 = (Product) object;
            if ( code.equals(product2.getCode())
                    &&id.equals(product2.getId())
                    && description.equals(product2.getDescription())
                    && amount == product2.getAmount()
                    && price == product2.getPrice()
                    && discount == product2.getDiscount()
                    &&madein.equals(product2.getMadein())
                    &&fabric.equals(product2.getFabric())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Code:        " + code + "\n"
                + "Id:            " + getId()+"\n"
                + "Description: " + description + "\n"
                + "amount:   " + amount + "\n"
                + "Price:       " + this.getFormattedPrice() + "\n"
                + "discount:    " + discount
                + "madein:     " + madein+ "\n"
                + "fabric:"+fabric;
    }
}

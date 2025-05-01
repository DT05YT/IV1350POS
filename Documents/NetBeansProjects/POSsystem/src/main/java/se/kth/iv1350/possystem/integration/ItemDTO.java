package se.kth.iv1350.possystem.integration;

/**
 *
 * @author Digit
 */
public class ItemDTO {
    private final int ID;
    private final java.lang.String name;
    private final double price;
    private final double VAT;
    private final int amount;
    private final java.lang.String desc;
    
    public ItemDTO(int ID, java.lang.String name, double price, double VAT, int amount, java.lang.String desc) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.amount = amount;
        this.desc = desc;
    }
    
    public int getID() {
        return this.ID;
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public double getVAT() {
        return this.VAT;
    }
    
    public final java.lang.String getDesc() {
        return this.desc;
    }
    
}

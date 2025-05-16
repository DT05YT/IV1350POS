package se.kth.iv1350.possystem.integration;
import se.kth.iv1350.possystem.model.SaleDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; //neccesary for reading files
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 *
 * @author Digit
 */
public class ExternalInventory {    
    
    private ItemDTO[] inventory;
    
    /*
    Generates a simulated External inventory with a supply of items.
    */
    public ExternalInventory() {
        try {
            this.inventory = itemListGenerator();  
        } catch (IOException e) {
            System.out.println("Failed to load items from csv file.");
        }
    }
    private ItemDTO[] itemListGenerator() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("fakeProducts.csv");
        if (inputStream == null) {
            throw new IOException("CSV file not found in resources folder.");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        ItemDTO[] itemList = new ItemDTO[50];
        String header = br.readLine(); // Skip the header

        int i = 0;
        while ((line = br.readLine()) != null && i < itemList.length) {
            String[] v = line.split(",", 6); // Split by comma, -1 to handle empty values
            itemList[i] = new ItemDTO(
                Integer.parseInt(v[0]),        // ID
                v[1],                          // Name
                Double.parseDouble(v[2]),      // Price
                Double.parseDouble(v[3]),      // VAT rate
                Integer.parseInt(v[4]),        // Description
                v[5]                           // Stock
            );
            i++;
        }
        br.close();
        return itemList;
    } //quantity equals how many left
    
    /*
    Updates the external inventory system
    
    @param saleInfo The current sale information to update with.
    */
    public void updateInventory(SaleDTO saleInfo) {
        //Not handled 
    }
    /*
    Returns the item with the corresponding ID.
    
    @param ID The ID of the looked after item.
    @param quantity The amount of items being bought.
    @throws ItemNotFoundException If the item does not exist.
    @throws DataBaseNotOnlineException If the database is not online (simulated)
    */
    public ItemDTO getItem(int ID, int quantity) throws ItemNotFoundException, DatabaseNotOnlineException {
        if (ID == 1001) {throw new DatabaseNotOnlineException();} //Should be replaced with actual online call in a real situation.
        for (ItemDTO item : this.inventory) {
            if (item.getID() == ID) {
                return new ItemDTO(ID, item.getName(), item.getPrice(), item.getVAT(), quantity, item.getDesc());
            }
        }
        throw new ItemNotFoundException(ID);
    }
}

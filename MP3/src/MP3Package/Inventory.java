/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP3Package;

/**
 * Inventory Class is used to keep track of all the items in the game.  
 * It creates the items and places them in the correct room.
 * Using the items in the correct location will add to the players score.
 * @author Georgia Snelling
 */
public class Inventory {
    
    //Instance variables
    private int inventoryNumber; //Item number in inventory
    private String itemName = ""; //Item name
    private boolean isItemUsed; //Is it being used
    private boolean isItemInInventory; //Is it in the inventory
    
    //Constructor
    public Inventory (int identification, boolean inUse, boolean inInventory)
    {
        this.inventoryNumber = identification;
        this.isItemUsed = inUse;
        this.isItemInInventory = inInventory;
    }
    
    /**
     * Gets the item needed
     * @return inventory number of object
     */
    public int getCurrentItem()
    {
        return inventoryNumber;
    }
    
    /**
     * Gets the name of the item 
     * @return The name of the item
     */
    public String getItemName()
    {
        switch (inventoryNumber)
        {
            case 0:
                itemName = "Portrait"; break;
            case 1:
                itemName = "State Papers"; break;
            case 2:
                itemName = "Fork"; break;
            case 3:
                itemName = "Spoon"; break;
            case 4:
                itemName = "Knife"; break;
            case 5:
                itemName = "Red Drapes"; break;
            case 6:
                itemName = "Spyglass"; break;
            case 7:
                itemName = "Blue Plate"; break;
            case 8:
                itemName = "Gold China"; break;
            default:
                itemName = "Nothing."; break;
        }
        
        return itemName;
    }
    
    /**
     * Sees if the item has been used
     * @param item 
     */
    public void setItemUsed (boolean item)
    {
        isItemUsed = item;
    }
    
    /**
     * Sets the item in the players inventory
     * @param item 
     */
    public void setInInventory(boolean item)
    {
        isItemInInventory = item;
    }
    
    /**
     * Checks to see if the item has been used
     * @return 
     */
    public boolean checkItemUse()
    {
        if (isItemUsed)
            return true;
        else
            return false;
    }
    
    /**
     * Checks if the item is in the players inventory
     * @return 
     */
    public boolean checkInInventory()
    {
        if (isItemInInventory)
            return true;
        else
            return false;
    }
    
    
  
}

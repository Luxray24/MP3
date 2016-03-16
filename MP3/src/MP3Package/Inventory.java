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
    String objectName;
    int foundLocation;
    int usedLocation;
    int objectPoints;
    
    //Constructor
    public Inventory (String name, int locationFound, int locationUsed, int points)
    {
        objectName = name;
        foundLocation = locationFound;
        usedLocation = locationUsed;
        objectPoints = points;
    }
    
    public void setName(String name) {
        this.objectName = name;
    }

    public String getName() {
        return objectName;
    }
    
    public void setPointValue(int points) {
        this.objectPoints = points;
    }

    public int getPointValue() {
        return objectPoints;
    }
    
    public void setLocationFound(int locationFound) {
        this.foundLocation = locationFound;
    }

    public int getLocationFound() {
        return foundLocation;
    }
    
    public void setLocationUsed(int locationUsed) {
        this.usedLocation = locationUsed;
    }

    public int getLocationUsed() {
        return usedLocation;
    }
    
    
    
  
}

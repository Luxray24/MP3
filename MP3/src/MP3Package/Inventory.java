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
    
    /**
     * Sets the name of the current object
     * @param name of object
     */
    public void setName(String name) 
    {
        this.objectName = name;
    }

    /**
     * Gets the name of the current object
     * @return object name
     */
    public String getName() 
    {
        return objectName;
    }
    
    /**
     * Sets the points for the object when used
     * @param points of the object when used
     */
    public void setPointValue(int points) 
    {
        this.objectPoints = points;
    }

    /**
     * Gets the amount of points when the object is used
     * @return the object points 
     */
    public int getPointValue() 
    {
        return objectPoints;
    }
    
    /**
     * Sets the location for where the object is found
     * @param locationFound location of where the object is found
     */
    public void setLocationFound(int locationFound) 
    {
        this.foundLocation = locationFound;
    }

    /**
     * Gets the location found
     * @return the location found
     */
    public int getLocationFound() 
    {
        return foundLocation;
    }
    
    /**
     * Sets the location used
     * @param locationUsed location of object used
     */
    public void setLocationUsed(int locationUsed) 
    {
        this.usedLocation = locationUsed;
    }

    /**
     * Gets the location of the object used
     * @return the used location
     */
    public int getLocationUsed() 
    {
        return usedLocation;
    }
    
    
    
  
}

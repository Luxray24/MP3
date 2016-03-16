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
    String name;
    String description;
    int locationFound;
    int locationUsed;
    int points;
    
    //Constructor
    public Inventory (String name, String description, int locationFound, int locationUsed, int points)
    {
        this.name = name;
        this.description = description;
        this.locationFound = locationFound;
        this.locationUsed = locationUsed;
        this.points = points;
    }
    
    
    
    
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP3Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Georgia Snelling
 */
class Room extends javax.swing.JFrame {

    //Instance variables 
    private int north; //Diretions
    private int south;
    private int east;
    private int west;
    private int up;
    private int down;
    private int pointValue; //Current amount of points
    private int currentRoom; //Current room
    private String shortDescription; //Short and long description of room
    private String longDescription;
    private String imageForRoom; //Image for room
    private String space = " ";
    


    //Constructor
    Room(int directionNorth, int directionSouth, int directionEast, int directionWest, int directionUp, int directionDown, int points, String imageSRC, String text, String textLong) 
    {
        north = directionNorth;
        south = directionSouth;
        east = directionEast;
        west = directionWest;
        up = directionUp;
        down = directionDown;
        pointValue = points;
        imageForRoom = imageSRC;
        setImageForRoom(imageForRoom);
        shortDescription = text;
        longDescription = textLong;
    }

    /**
     * Sets the current room
     * @param currentRoom the room number
     */
    public void setRoom(int currentRoom) 
    {
        this.currentRoom = currentRoom;
    }

    /**
     * Gets the room number
     * @return current room number
     */
    public int getRoom() 
    {
        return currentRoom;
    }

    /**
     * Sets the room points
     * @param points points for room
     */
    public void setPointValue(int points) 
    {
        this.pointValue = points;
    }

    /**
     * Gets the point value for each room
     * @return the point value
     */
    public int getPointValue() 
    {
        return pointValue;
    }

    /**
     * Sets the image for each room
     * @param image image name
     */
    public void setImageForRoom(String imageForRoom) 
    {
        this.imageForRoom = imageForRoom;
    }

    /**
     * Gets the image for room
     * @return image file name for the room
     */
    public String getImageForRoom() 
    {
        return imageForRoom;
    }

    public void setShortDescription(String shortDescription) 
    {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() 
    {
        return shortDescription;
    }

    public void setLongDescription(String longDescription) 
    {
        this.longDescription = longDescription;
    }

    public String getLongDescription() 
    {
        return longDescription;
    }

    public void setNorth(int north) 
    {
        this.north = north;
    }

    public int getNorth() 
    {
        return north;
    }

    public void setSouth(int south) 
    {
        this.south = south;
    }

    public int getSouth() 
    {
        return south;
    }

    public void setEast(int east)
    {
        this.east = east;
    }

    public int getEast() 
    {
        return east;
    }

    public void setWest(int west) 
    {
        this.west = west;
    }

    public int getWest() 
    {
        return west;
    }

    public void assignDirections(String directions) 
    {
        String[] temp = directions.split(" ");
        int tempNorth = Integer.parseInt(temp[0]);
        int tempSouth = Integer.parseInt(temp[1]);
        int tempEast = Integer.parseInt(temp[2]);
        int tempWest = Integer.parseInt(temp[3]);

        setNorth(tempNorth);
        setSouth(tempSouth);
        setEast(tempEast);
        setWest(tempWest);
    }


}

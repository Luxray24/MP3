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
    private ImageIcon imageForRoom; //Image for room
    private String space = " ";
    private String image;

//    ArrayList<Room> rooms = new ArrayList<Room>();
//    Room currentRoom = null;
    

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
        image = imageSRC;
        shortDescription = text;
        longDescription = textLong;
    }

    public void setRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getRoom() {
        return currentRoom;
    }

    public void setPointValue(int points) {
        this.pointValue = points;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setImageForRoom(String image) {
        this.imageForRoom = new ImageIcon("/images/" + image );
    }

    public ImageIcon getImageForRoom() {
        return imageForRoom;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setNorth(int north) {
        this.north = north;
    }

    public int getNorth() {
        return north;
    }

    public void setSouth(int south) {
        this.south = south;
    }

    public int getSouth() {
        return south;
    }

    public void setEast(int east) {
        this.east = east;
    }

    public int getEast() {
        return east;
    }

    public void setWest(int west) {
        this.west = west;
    }

    public int getWest() {
        return west;
    }

    public void assignDirections(String directions) {
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

    public int getNextDirection(String choice) {
        String temp = choice;
        int next;

        if (temp.equals("go north") || temp.equals("north") || temp.equals("move north") || temp.equals("n")) {
            next = getNorth();
        } else if (temp.equals("go south") || temp.equals("south") || temp.equals("move south") || temp.equals("s")) {
            next = getSouth();
        } else if (temp.equals("go east") || temp.equals("east") || temp.equals("move east") || temp.equals("e")) {
            next = getEast();
        } else if (temp.equals("go west") || temp.equals("west") || temp.equals("move west") || temp.equals("w")) {
            next = getWest();
        } else {
            next = -1;
        }

        return next;
    }

    public boolean checkRoomForItem(int roomNumber) {
        if (roomNumber == 0) {
            return true;
        } else if (roomNumber == 1) {
            return true;
        } else if (roomNumber == 4) {
            return true;
        } else if (roomNumber == 5) {
            return true;
        } else if (roomNumber == 8) {
            return true;
        } else if (roomNumber == 10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkRoomForItemUse(int roomNumber) {
        if (roomNumber == 15) {
            return true;
        } else if (roomNumber == 16) {
            return true;
        } else if (roomNumber == 21) {
            return true;
        } else if (roomNumber == 22) {
            return true;
        } else if (roomNumber == 23) {
            return true;
        } else {
            return false;
        }
    }

}

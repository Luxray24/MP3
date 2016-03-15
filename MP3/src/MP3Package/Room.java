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
    private int north; //Dicretions
    private int south;
    private int east;
    private int west;
    private int pointValue; //Current amount of points
    private int currentRoom; //Current room
    private String shortDescription; //Short and long description of room
    private String longDescription;
    private ImageIcon imageForRoom; //Image for room
    private String space = " ";
    
//    ArrayList<Room> rooms = new ArrayList<Room>();
//    Room currentRoom = null;

    
    
    //Constructor
    Room() 
    {
        
    }

    private Room(int parseInt, int parseInt0, int parseInt1, int parseInt2, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void readFile(File file)
    {
        int room = 0;
        String directions = " ";
        int points = 0;
        String image = "";
        String shortDescription = ""; 
        String longDescription = "";
        String temp = "";
        
        try
        {
            FileReader in = new FileReader(file);
            BufferedReader br = new BufferedReader(in);
            
            room = Integer.parseInt(br.readLine());
            directions = br.readLine();
            points = Integer.parseInt(br.readLine());
            image = br.readLine();
            shortDescription = br.readLine(); 
            setRoom(room);
            setPointValue(points);
            setImageForRoom(image);
            setShortDescription(shortDescription);
            assignDirections(directions);
            
            for (int i = 0; i < 6; i++)
            {
                temp = br.readLine();
                if (temp == null)
                    temp = "\n";
                
                longDescription += temp + " ";
            }
            
            setLongDescription( longDescription);
            
            in.close();
            br.close();
        }
        catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        

//try {
//            // open up data file stored in src/data/roomdata.txt
//            // remember that the "src" folder is the root for JAR-based file resources
//            InputStreamReader isr = new InputStreamReader(  
//                                        this.getClass().getResourceAsStream("/data/roomdata.txt") );
//            BufferedReader br     = new BufferedReader( isr );
//            
//            // read in the file - assuming it has correct format for each room of:
//            // 1. comment line
//            // 2. line of four space-separated integers representing connecting 
//            //    rooms to (in order) the north, south, east, and west.
//            //    The value -1 is used to indicate no connection in that direction.
//            // 3. Line of descriptive text associated with the room.
//            while ( true ) {
//                String comment = br.readLine();
//                if ( comment == null ) break;
//                
//                String roomConnections = br.readLine();
//                // split will use the passed delimiter to split a string
//                // into multiple strings housed in an array.
//                String[] nsew = roomConnections.split( " " );
//                String text = br.readLine();
//                Room newRoom = new Room( Integer.parseInt( nsew[0] ),
//                                         Integer.parseInt( nsew[1] ),
//                                         Integer.parseInt( nsew[2] ),
//                                         Integer.parseInt( nsew[3] ),
//                                         text                         );
//                rooms.add( newRoom );
//            }
//            br.close();
//        }
//        catch ( IOException e ) {
//        }
//        
//        currentRoom = rooms.get( 0 );
//        displayRoomInfo();

        
    }
    
    public void setRoom(int currentRoom)
    {
        this.currentRoom = currentRoom;
    }
    
    public int getRoom()
    {
        return currentRoom;
    }
    
   
    
    public void setPointValue(int points)
    {
        this.pointValue = points;
    }
    
    public int getPointValue()
    {
        return pointValue;
    }
    
    
    
    public void setImageForRoom( String image)
    {
        this.imageForRoom = new ImageIcon("./images/" + image);
    }
    
    public ImageIcon getImageForRoom()
    {
        return imageForRoom;
    }
    
    
    
    public void setShortDescription( String shortDescription)
    {
        this.shortDescription = shortDescription;
    }
    
    public String getShortDescription( )
    {
        return shortDescription;
    }
    
    
    
    public void setLongDescription( String longDescription)
    {
        this.longDescription = longDescription;
    }
    
    public String getLongDescription( )
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
        String[] temp = directions.split(space);
        int tempNorth = Integer.parseInt(temp[0]);
        int tempSouth = Integer.parseInt(temp[1]);
        int tempEast = Integer.parseInt(temp[2]);
        int tempWest = Integer.parseInt(temp[3]);
        
        setNorth(tempNorth);
        setSouth(tempSouth);
        setEast(tempEast);
        setWest(tempWest);
    }
    
    public int getNextDirection(String choice)
    {
        String temp = choice;
        int next;
        
        if (temp.equals("go north") || temp.equals("north") || temp.equals("move north") || temp.equals("n"))
            next = getNorth();
        else if (temp.equals("go south") || temp.equals("south") || temp.equals("move south") || temp.equals("s"))
            next = getSouth();
        else if (temp.equals("go east") || temp.equals("east") || temp.equals("move east") || temp.equals("e"))
            next = getEast();
        else if (temp.equals("go west") || temp.equals("west") || temp.equals("move west") || temp.equals("w"))
            next = getWest();
        else
            next = -1;
        
        return next;
    }
    
    
    public boolean checkRoomForItem(int roomNumber)
    {
        if (roomNumber == 0 )
            return true;
        else if (roomNumber == 1)
            return true;
        else if (roomNumber == 4)
            return true;
        else if (roomNumber == 5)
            return true;
        else if (roomNumber == 8)
            return true;
        else if (roomNumber == 10)
            return true;
        else
            return false;
    }
    
    public boolean checkRoomForItemUse (int roomNumber)
    {
        if (roomNumber == 15 )
            return true;
        else if (roomNumber == 16)
            return true;
        else if (roomNumber == 21)
            return true;
        else if (roomNumber == 22)
            return true;
        else if (roomNumber == 23)
            return true;
        else
            return false;
    }
    
    
    
    
    
    
    
    
    
    
}

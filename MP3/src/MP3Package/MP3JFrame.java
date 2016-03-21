/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP3Package;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * This is an interactive fiction game.  
 * You are playing as Dolley Madison and you collect different items in the White House before
 * the British burn it down.  You get points for each room you explore.
 * @author Georgia Snelling
 */
public class MP3JFrame extends javax.swing.JFrame {

    //initializing points.
    int points = 0;
            
    //Initializing the Room list array
    ArrayList<Room> rooms = new ArrayList<Room>();
    Room currentRoom = null;
    
    //Initializing the objects array
    ArrayList<Inventory> objects = new ArrayList<Inventory>();
    Inventory items = null;
    
    
    //Initializing the player inventory array
    ArrayList<Inventory> playerInventory = new ArrayList<Inventory>();
    Inventory personalInventory = null;

    /**
     * Creates new form MP3JFrame
     */
    public MP3JFrame() {
        initComponents();

        //Intro to game!  Describes who you are and the situation at hand.
        ImageIcon dolleyIcon; //Dolley Madison pictures
        String filename = "/images/Dolley.jpg"; //Filename for the image
        dolleyIcon = new ImageIcon(getClass().getResource(filename)); //Getting the image
        String message = "Your name is Dolley Madison. \n \n"  //Intro description to the game
                + "President James Madison has left the White House \n"
                + "to meet with his generals on the battlefield, \n"
                + "as British troops have threatened to enter the capitol. \n \n"
                + "Before leaving, he asked you to gather important objects \n"
                + "and to be prepared to abandon the White House at any moment. \n \n"
                + "Currently, the British are coming and you must gather the \n"
                + "most important items you can find and drop them off in the right places!";
        String title = "The British are Coming!"; //Title
        int messageType = JOptionPane.INFORMATION_MESSAGE; //Message Type as information

        JOptionPane.showMessageDialog(null, message, title, messageType, dolleyIcon); //Message Dialog introducing the game.

        
        //Streams the files
        try {
            // open up data file stored in src/data/roomdata.txt
            // remember that the "src" folder is the root for JAR-based file resources
            InputStreamReader isr = new InputStreamReader(
                    this.getClass().getResourceAsStream("/data/Rooms.txt"));
            BufferedReader br = new BufferedReader(isr);

            // read in the file - assuming it has correct format for each room of:
            // 1. comment line
            // 2. line of four space-separated integers representing connecting 
            //    rooms to (in order) the north, south, east, and west.
            //    The value -1 is used to indicate no connection in that direction.
            // 3. Line of descriptive text associated with the room. (Short)
            // 4. Long description of room.
            // 5. END
            while (true) {
                String comment = br.readLine();
                if (comment == null) {
                    break;
                }

                int roomNumber = Integer.parseInt(br.readLine());
                String roomConnections = br.readLine();
                // split will use the passed delimiter to split a string
                // into multiple strings housed in an array.
                String[] nsew = roomConnections.split(" ");
                int points = Integer.parseInt(br.readLine());
                String imageSRC = br.readLine();
                String text = br.readLine();
                String textLong = br.readLine();
                Room newRoom = new Room(Integer.parseInt(nsew[0]),
                        Integer.parseInt(nsew[1]),
                        Integer.parseInt(nsew[2]),
                        Integer.parseInt(nsew[3]),
                        Integer.parseInt(nsew[4]),
                        Integer.parseInt(nsew[5]),
                        points,
                        imageSRC,
                        text,
                        textLong, roomNumber);
                rooms.add(newRoom);
                String end = br.readLine();
                System.out.println(textLong);
            }
            br.close();
        } 
        catch (IOException e) 
        {
            
        }

                 
        
        //Objects
        try {
            // open up data file stored in src/data/roomdata.txt
            // remember that the "src" folder is the root for JAR-based file resources
            InputStreamReader isr = new InputStreamReader(
                    this.getClass().getResourceAsStream("/data/Items.txt"));
            BufferedReader br = new BufferedReader(isr);

            // read in the file - assuming it has correct format for each room of:
            // 1. Name line
            // 2. 3 numbers.  First is where is it located, second is where it is used, thrid is amount of points
            // 3. END
            while (true) {
                
                String objectName = br.readLine();
                String itemConnections = br.readLine();
                // split will use the passed delimiter to split a string
                // into multiple strings housed in an array.
                String[] nsew = itemConnections.split(" ");
                Inventory newInventory = new Inventory(objectName, Integer.parseInt(nsew[0]),
                        Integer.parseInt(nsew[1]),
                        Integer.parseInt(nsew[2]));
                objects.add(newInventory);
                
                String end = br.readLine();
                if (end == null) 
                {
                    break;
                }
            }
            br.close();
        } 
        catch (IOException e) 
        {
            
        }

        
        
        currentRoom = rooms.get( 0 ); //Sets the first room
        ImageIcon roomImage;
        String roomImageFileName = currentRoom.getImageForRoom();
        roomImage = new ImageIcon("C:\\Users\\animalcrackers48\\Documents\\Programming\\MP3\\MP3\\src\\images\\" + roomImageFileName );
        imageLabel.setIcon(roomImage);
        displayRoomInfo(); // Displays the room information
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        commandJLabel = new javax.swing.JLabel();
        commandTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        commandJLabel.setText("Command:");

        commandTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandTextFieldActionPerformed(evt);
            }
        });

        descriptionTextArea.setEditable(false);
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(descriptionTextArea);

        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imageLabel.setMaximumSize(new java.awt.Dimension(400, 200));
        imageLabel.setMinimumSize(new java.awt.Dimension(400, 200));
        imageLabel.setPreferredSize(new java.awt.Dimension(400, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(commandJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                .addGap(167, 167, 167))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commandJLabel)
                    .addComponent(commandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void commandTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandTextFieldActionPerformed
        
        String command = commandTextField.getText().toLowerCase(); //Reads in command
        descriptionTextArea.append(">" + command + "\n "); //Pritns it out in text area
        commandTextField.setText("");
        
            
        //Compares the command with different options, resulting in different things.
        if (command.equals("quit"))  //Quitting the game
        {
            System.exit(1);
        } 
        else if (command.equals("score")) //Gets score and prints it out
        {
            descriptionTextArea.append("Your score is: " + points + "\n \n");
        }
        else if (command.equals("go north") || command.equals("north") || command.equals("move north") || command.equals("n")) //Moves the player north if possible
        {
            //Checks if you can go north
            if (currentRoom.getNorth() < 0) //Direction is -1 so you cannot go that way
            {
                descriptionTextArea.append( "You cannot go that way.  Please try again. \n \n");
            }
            else //You can go this way and it sets the current room as the new room
            {
                currentRoom = rooms.get( currentRoom.getNorth() );
                currentRoom.setRoom( currentRoom.getRoom() );
                
                displayRoomInfo();
            }
            
            ImageIcon roomImage;
            String roomImageFileName = currentRoom.getImageForRoom();
            roomImage = new ImageIcon("C:\\Users\\animalcrackers48\\Documents\\Programming\\MP3\\MP3\\src\\images\\" + roomImageFileName );
            imageLabel.setIcon(roomImage);
            
            points += 5;
        }
        else if (command.equals("go south") || command.equals("south") || command.equals("move south") || command.equals("s")) //Moves the player south if possible
        {
            
            //Checks if you can go south
            if (currentRoom.getSouth() < 0) //Direction is -1 so you cannot go that way
            {
                descriptionTextArea.append( "You cannot go that way.  Please try again. \n \n");
            }  
            else //You can go this way and it sets the current room as the new room 
            {
                currentRoom = rooms.get( currentRoom.getSouth() );
                currentRoom.setRoom( currentRoom.getRoom() );
                
                displayRoomInfo();
            }
            
            ImageIcon roomImage;
            String roomImageFileName = currentRoom.getImageForRoom();
            roomImage = new ImageIcon("C:\\Users\\animalcrackers48\\Documents\\Programming\\MP3\\MP3\\src\\images\\" + roomImageFileName );
            imageLabel.setIcon(roomImage);
            
            points += 5;
        }
        else if (command.equals("go east") || command.equals("east") || command.equals("move east") || command.equals("e")) //Moves the player east if possible
        {
            //Checks if you can go east
            if (currentRoom.getEast() < 0) //Direction is -1 so you cannot go that way
            {
                descriptionTextArea.append( "You cannot go that way.  Please try again. \n \n");
            }
            else //You can go this way and it sets the current room as the new room 
            {
                currentRoom = rooms.get( currentRoom.getEast() );
                currentRoom.setRoom( currentRoom.getRoom() );
                
                
                displayRoomInfo();
            }
            
            ImageIcon roomImage;
            String roomImageFileName = currentRoom.getImageForRoom();
            roomImage = new ImageIcon("C:\\Users\\animalcrackers48\\Documents\\Programming\\MP3\\MP3\\src\\images\\" + roomImageFileName );
            imageLabel.setIcon(roomImage);
            points += 5;
        }
        else if (command.equals("go west") || command.equals("west") || command.equals("move west") || command.equals("w")) //Moves the player west if possible
        {
            //Checks if you can go west
            if (currentRoom.getWest() < 0) //Direction is -1 so you cannot go that way
            {
                descriptionTextArea.append( "You cannot go that way.  Please try again. \n \n");
            }
            else //You can go this way and it sets the current room as the new room 
            {
                currentRoom = rooms.get( currentRoom.getWest() );
                currentRoom.setRoom( currentRoom.getRoom() );
                
                displayRoomInfo();
            }
            
            ImageIcon roomImage;
            String roomImageFileName = currentRoom.getImageForRoom();
            roomImage = new ImageIcon("C:\\Users\\animalcrackers48\\Documents\\Programming\\MP3\\MP3\\src\\images\\" + roomImageFileName );
            imageLabel.setIcon(roomImage);
            points += 5;
        }
        else if (command.equals("look") || command.equals("l")) //Look at the current room description
        {
            displayRoomInfo();
            
            
        }
        else if (command.startsWith("take")) //Adds item into player inventory
        {
            if (command.equals("take all")) //Takes all the items
            {
                int j = 0;
                int size = objects.size();
                for (int i = 0; i < size; i++)
                {
                    items = objects.get(j);
                    if (items.getLocationFound() == currentRoom.getRoom())
                    {
                        playerInventory.add(items);
                        objects.remove(items);
                        j -= 1;
                    }
                    j += 1;
                }
                
                descriptionTextArea.append("Everything in this room was added to your inventory. \n \n");
            }
            else //Takes specified item
            {
                int size = objects.size();
                for (int i = 0; i < size; i++)
                {
                    
                    items = objects.get(i);
                    if (command.contains(items.getName()) && items.getLocationFound() == currentRoom.getRoom())
                    {
                        playerInventory.add(items);
                        objects.remove(items);
                        descriptionTextArea.append(items.getName() + " was added to your inventory. \n \n");
                    }
                    else if (command.contains(items.getName()) && items.getLocationFound() != currentRoom.getRoom())
                    {
                        descriptionTextArea.append("That item is not in this room. \n \n");
                    }


                } 
            }
        }
        
        else if (command.startsWith("drop")) //Drops item into the room
        {
            if (command.equals("drop all")) //Drops all the things
            {
                int j = 0;
                int size = playerInventory.size();
                for (int i = 0; i < size; i++)
                {
                    personalInventory = playerInventory.get(j);
                    playerInventory.remove(personalInventory);
                    objects.add(personalInventory);
                    items = objects.get(objects.size()-1);
                    items.setLocationFound(currentRoom.getRoom());
                    
                } 
                descriptionTextArea.append("Everything was dropped from your inventory. \n \n");
                
            }
            else //Drops specified object
            {
                int size = playerInventory.size();
                for (int i = 0; i < size; i++)
                {
                    personalInventory = playerInventory.get(i);
                    if (command.contains(personalInventory.getName()))
                    {
                        playerInventory.remove(personalInventory);
                        objects.add(personalInventory);
                        items = objects.get(objects.size()-1);
                        items.setLocationFound(currentRoom.getRoom());
                        descriptionTextArea.append(personalInventory.getName() + " was dropped from your inventory. \n \n");
                    }

                } 
            }
        }
        else if (command.equals("inventory") || command.equals("i")) //Prints out the inventory of the player
        {
            descriptionTextArea.append( "The objects in your inventory are: \n");
            for (int i = 0; i < playerInventory.size(); i++)
            {
                
                personalInventory = playerInventory.get(i);
                descriptionTextArea.append(personalInventory.getName() + "\n");
            }
            descriptionTextArea.append( "\n");
        }
        else //If what the player doesnt make sense it prints this out
        {
            descriptionTextArea.append("That isn't a command I know.  Please try again. \n \n");
        }
        

    }//GEN-LAST:event_commandTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MP3JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MP3JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MP3JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MP3JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MP3JFrame().setVisible(true);
            }
        });
    }
    
    private void displayRoomInfo() //Prints the description of the current room
    {
        descriptionTextArea.append( currentRoom.getLongDescription() + "\n \n" );
        
        descriptionTextArea.append( "You see: " );
        for (int i = 0; i < objects.size(); i++)
        {
            items = objects.get(i);
            if (items.getLocationFound() == currentRoom.getRoom())
            {
                descriptionTextArea.append( items.getName() + "\n" );
            }
        }
        descriptionTextArea.append( "\n" );    
        
    }
    

   

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel commandJLabel;
    private javax.swing.JTextField commandTextField;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

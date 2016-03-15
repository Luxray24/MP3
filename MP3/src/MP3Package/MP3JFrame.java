/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP3Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Georgia Snelling
 */
public class MP3JFrame extends javax.swing.JFrame {

    //int currentRoom = 0;
    int previousRoom = 0;
    boolean itemInRoom = false;
    int points = 0;
    int totalPoints = 0;
    int pointValue = 25;
    final int ROOM = 24;
    int choice;
    boolean dontGivePoints;
    int numberOfRooms = 0;
    String nextRoom;
    String descriptionAreaStr = "";
    String shortDescriptionStr = "";
    ImageIcon roomPicture;
    int nextFile;

    Inventory[] gameInventory = new Inventory[8];
    int[] roomArray = new int[24];
    Room adventure = new Room();
    File[] fileArray = new File[24];
    Room occupiedRoom = null;

    ArrayList<Room> rooms = new ArrayList<Room>();
    Room currentRoom = null;

    /**
     * Creates new form MP3JFrame
     */
    public MP3JFrame() {
        initComponents();

        //Intro to game!  Describes who you are and the situation at hand.
        ImageIcon dolleyIcon; //Dolley Madison pictures
        String filename = "/images/Dolley.jpg"; //Filename for the image
        dolleyIcon = new ImageIcon(getClass().getResource(filename)); //Getting the image
        String message = "Your name is Dolley Madison. \n \n"
                + //Intro description to the game
                "President James Madison has left the White House \n"
                + "to meet with his generals on the battlefield, \n"
                + "as British troops have threatened to enter the capitol. \n \n"
                + "Before leaving, he asked you to gather important objects \n"
                + "and to be prepared to abandon the White House at any moment. \n \n"
                + "Currently, the British are coming and you must gather the \n"
                + "most important items you can find and drop them off in the right places!";
        String title = "The British are Coming!"; //Title
        int messageType = JOptionPane.INFORMATION_MESSAGE; //Message Type as information

        JOptionPane.showMessageDialog(null, message, title, messageType, dolleyIcon); //Message Dialog introducing the game.

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
            // 3. Line of descriptive text associated with the room.
            while (true) {
                String comment = br.readLine();
                if (comment == null) {
                    break;
                }

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
                        textLong);
                rooms.add(newRoom);
                String abc = br.readLine();
                System.out.println(textLong);
            }
            br.close();
        } catch (IOException e) {
        }

        currentRoom = rooms.get(0);
        displayRoomInfo();

        setLocationRelativeTo(null);

//        for( int k = 0; k < 8; k++)
//        {
//            gameInventory[k] = new Inventory(k, false, false);
//        }
//        for( int i = 0; i <= 23; i++)
//        {
//            String roomFileName = "src/data/Room_" + i + ".txt";
//            fileArray[i] = new File(roomFileName);
//        }
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
        imageJPanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        commandJLabel.setText("Command:");

        commandTextField.setText(" ");
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

        imageJPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imageJPanel.setMaximumSize(new java.awt.Dimension(460, 300));
        imageJPanel.setMinimumSize(new java.awt.Dimension(460, 300));
        imageJPanel.setPreferredSize(new java.awt.Dimension(460, 300));

        javax.swing.GroupLayout imageJPanelLayout = new javax.swing.GroupLayout(imageJPanel);
        imageJPanel.setLayout(imageJPanelLayout);
        imageJPanelLayout.setHorizontalGroup(
            imageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );
        imageJPanelLayout.setVerticalGroup(
            imageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageJPanelLayout.createSequentialGroup()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 198, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 169, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(imageJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(167, 167, 167))
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(commandJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        // TODO add your handling code here:
        points = 0;

        nextRoom = commandTextField.getText().toLowerCase();
        descriptionTextArea.append(">" + nextRoom + "\n");
        commandTextField.setText("");

        if (nextRoom.equals("quit")) {
            System.exit(1);
        } else if (nextRoom.equals("score")) {
//                adventure.setNorth(currentRoom);
//                adventure.setSouth(currentRoom);
//                adventure.setEast(currentRoom);
//                adventure.setWest(currentRoom);
            descriptionTextArea.append("Your score is: " + totalPoints + ". \n");
            dontGivePoints = true;
            points = 0;

        }

        //adventure.assignDirections(nextRoom);
        nextFile = adventure.getNextDirection(nextRoom);

        if (nextFile == -1) {
//            adventure.setNorth(currentRoom);
//            adventure.setSouth(currentRoom);
//            adventure.setEast(currentRoom);
//            adventure.setWest(currentRoom);
            descriptionTextArea.append("You cannot go that way.  Try another direction. \n");
            dontGivePoints = true;
            points = 0;
        } //        else if (nextFile == east)
        //        {
        //        
        //        }
        else {
            points = 0;

        }

        //previousRoom = currentRoom;

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

    private void displayRoomInfo() {
        descriptionTextArea.append(occupiedRoom.getLongDescription());
    }

    private void move(int direction) {
        if (direction < 0) {
            String s = "You can't go in that direction.\n" + occupiedRoom.getLongDescription();
            descriptionTextArea.append(s);
            return;
        }

        occupiedRoom = rooms.get(direction);
        displayRoomInfo();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel commandJLabel;
    private javax.swing.JTextField commandTextField;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JPanel imageJPanel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

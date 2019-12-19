package View;

import Model.CarModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.


public class DrawPanel extends JPanel {


    // Hardcoded instance variables of vehicle images.
    private BufferedImage saabImage;
    private BufferedImage volvoImage;
    private BufferedImage scaniaImage;

    private ArrayList<String> vehicles;

    //TODO: Make points general for all cars no matter how many.
    private Point saabPoint = new Point(10, 10);
    private Point volvoPoint = new Point(10, 110);
    private Point scaniaPoint = new Point(10, 210);

    DrawPanel(int x, int y) {
        // Initializes the panel and reads the images
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.gray);
        // Print an error message in case file is not found with a try/catch block
        try {
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Scania.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Saab95.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Volvo240.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void moveIt(int x, int y, String modelType) {
        switch (modelType) {
            case "Scania":
                scaniaPoint.x = x;
                scaniaPoint.y = y;
                break;
            case "Saab95":
                saabPoint.x = x;
                saabPoint.y = y;
                break;
            case "Volvo240":
                volvoPoint.x = x;
                volvoPoint.y = y;
                break;
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Add a method call to fix the Vehicles Null pointer issue
    @Override
    protected void paintComponent(Graphics g) {
        for (String v : vehicles) {
            super.paintComponent(g);
            switch (v) {
                case "Scania":
                    g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null); // see javadoc for more info on the parameters
                    break;
                case "Volvo240":
                    g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
                    break;
                case "Saab95":
                    g.drawImage(saabImage, saabPoint.x, saabPoint.y, null); // see javadoc for more info on the parameters
                    break;
            }
        }
    }
}


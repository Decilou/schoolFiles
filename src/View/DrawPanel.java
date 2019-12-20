package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import Event.ICarEventListener;
import Model.CarEvent;

// This panel represent the animated part of the view with the car images.


public class DrawPanel extends JPanel implements ICarEventListener {

    // Instance variables for vehicle images.
    private BufferedImage saabImage;
    private BufferedImage volvoImage;
    private BufferedImage scaniaImage;

    private CarEvent currentCarEvent;

    private ArrayList<String> vehicles;

    //TODO: Make points general for all cars no matter how many. Make dependent on CarEvent instead.
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

    //TODO: Use CarEvent to fix point-issue.
    void moveIt(CarEvent currentCarEvent) {
        this.currentCarEvent = currentCarEvent;
        switch (currentCarEvent.getModelName()) {

            //TODO: These cases should be replaced by ONE point that is continuously update as a new currentCarEvent enters.
            case "Saab95":
                saabPoint.x = currentCarEvent.getX();
                saabPoint.y = currentCarEvent.getY();
                break;
            case "Scania":
                scaniaPoint.x = currentCarEvent.getX();
                scaniaPoint.y = currentCarEvent.getY();
                break;
            case "Volvo240":
                volvoPoint.x = currentCarEvent.getX();
                volvoPoint.y = currentCarEvent.getY();
                break;
        }
    }

    // TODO: Add a method call to fix the Vehicles Null pointer issue
    private boolean isCarEventNull() {
        return currentCarEvent == null;
    }

    //TODO: Nu finns två av bilarna i EN frame sedan försvinner dom.
    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        if (isCarEventNull()) {
            super.paintComponent(g);
            g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
            g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null); // see javadoc for more info on the parameters
            g.drawImage(saabImage, saabPoint.x, saabPoint.y, null); // see javadoc for more info on the parameters
        } else {
            //TODO: Should not be duplicate code.
            super.paintComponent(g);
            switch (currentCarEvent.getModelName()) {
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


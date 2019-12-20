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
    private Point point = new Point();

    public DrawPanel(int x, int y) {
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
        point.setLocation(currentCarEvent.getX(), currentCarEvent.getY());
    }

    public void update(CarEvent currentCarEvent) {
        this.currentCarEvent = currentCarEvent;
    }

    //TODO: Nu finns två av bilarna i EN frame sedan försvinner dom.
    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {
        if (currentCarEvent == null) {
            super.paintComponent(g);
        } else {
            //TODO: Should not be duplicate code.
            super.paintComponent(g);
            switch (currentCarEvent.getModelName()) {
                case "Scania":
                    g.drawImage(scaniaImage, point.x, point.y, null); // see javadoc for more info on the parameters
                    break;
                case "Volvo240":
                    g.drawImage(volvoImage, point.x, point.y, null); // see javadoc for more info on the parameters
                    break;
                case "Saab95":
                    g.drawImage(saabImage, point.x, point.y, null); // see javadoc for more info on the parameters
                    break;
            }

        }
    }
}


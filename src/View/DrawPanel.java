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

    private ArrayList<CarEvent> drawingObjects = new ArrayList<>();

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

    //Update the currentCarEvent to the new one and set th temporary point accordingly.
    public void update(ArrayList<CarEvent> drawingObjects) {
        this.drawingObjects = drawingObjects;
    }

    private Image selectImage(String modelName) {
        if (modelName.equals("Scania")) {
            return scaniaImage;
        } else if (modelName.equals("Saab95")) {
            return saabImage;
        } else {
            return volvoImage;
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CarEvent car : drawingObjects) {
            g.drawImage(selectImage(car.getModelName()), car.getX(), car.getY(), null);
        }
    }
}


package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Model.Vehicle;

// This panel represent the animated part of the view with the car images.

public class DrawPanel<T extends Vehicle> extends JPanel {

    // Hardcoded instance variables of vehicle images.
    BufferedImage saabImage;
    BufferedImage volvoImage;
    BufferedImage scaniaImage;

    // Hardcoded starting points for all different vehicles.
    Point saabPoint = new Point(10, 10);
    Point volvoPoint = new Point(10, 110);
    Point scaniaPoint = new Point(10, 210);

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

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void moveIt(int x, int y, Vehicle v) {

        if (v.getModelName().equals("Model.Scania")) {
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        } else if (v.getModelName().equals("Model.Saab95")) {
            saabPoint.x = x;
            saabPoint.y = y;
        } else if (v.getModelName().equals("Model.Volvo240")) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null); // see javadoc for more info on the parameters
    }
}

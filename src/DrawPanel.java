import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel<T extends Vehicle> extends JPanel {

    // TODO: Hardcode instance variable for each image.
    BufferedImage saabImage;
    BufferedImage volvoImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position
    Point saabPoint = new Point(10, 10);
    Point volvoPoint = new Point(10, 110);
    Point scaniaPoint = new Point(10, 210);

    public DrawPanel(int x, int y) {
        // Initializes the panel and reads the images
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.gray);
        // Print an error message in case file is not found with a try/catch block
        try {
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    void moveIt(int x, int y, Vehicle v) {

        if (v.getModelName().equals("Scania")) {
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        } else if (v.getModelName().equals("Saab95")) {
            saabPoint.x = x;
            saabPoint.y = y;
        } else if (v.getModelName().equals("Volvo240")) {
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

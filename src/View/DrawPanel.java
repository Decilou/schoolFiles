package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Model.Vehicle;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Hardcoded instance variables of vehicle images.
    private BufferedImage saabImage;
    private BufferedImage volvoImage;
    private BufferedImage scaniaImage;

    // Hardcoded starting points for all different vehicles.
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

    void moveIt(int x, int y, Vehicle v) {

        switch (v.getModelName()) {
            case "Model.Scania":
                scaniaPoint.x = x;
                scaniaPoint.y = y;
                break;
            case "Model.Saab95":
                saabPoint.x = x;
                saabPoint.y = y;
                break;
            case "Model.Volvo240":
                volvoPoint.x = x;
                volvoPoint.y = y;
                break;
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

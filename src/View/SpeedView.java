package View;

import Model.CarEvent;
import Event.ICarEventListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;

public class SpeedView extends JFrame implements ICarEventListener {

    private JPanel panel= new JPanel();
    private CarEvent currentCarEvent;

    public SpeedView(String frameName) {
        initComponents(frameName);
    }


    public void update(CarEvent currentCarEvent) {
        this.currentCarEvent = currentCarEvent;
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(200 , 300));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));



        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width, 0);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}

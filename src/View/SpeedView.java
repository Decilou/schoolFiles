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
    private JLabel name = new JLabel("< Vehicle model name >");
    private JLabel speed = new JLabel("< Current speed of vehicle >");


    private JPanel carFactPanel = new JPanel();

    public SpeedView(String frameName) {
        initComponents(frameName);
    }

    public void update(CarEvent currentCarEvent) {
        this.currentCarEvent = currentCarEvent;
        name.setText(currentCarEvent.getModelName());
        speed.setText(currentCarEvent.toString());
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(200 , 80));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        carFactPanel.setLayout(new BorderLayout());
        carFactPanel.add(name, BorderLayout.PAGE_START);
        carFactPanel.add(speed, BorderLayout.PAGE_END);


        this.add(carFactPanel);



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

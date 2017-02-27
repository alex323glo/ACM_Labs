package Lab_1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexey_O on 23.02.2017.
 */
public class Resources {
    public static JFrame createJFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = (Toolkit.getDefaultToolkit()).getScreenSize();
        jFrame.setBounds(dimension.width / 4, dimension.height / 4, dimension.width / 2, dimension.height / 2);
        jFrame.setTitle("This my app");
        return jFrame;
    }

    static void fixConstraint (GridBagConstraints constraints, int x, int y, int width, int height, int xWeight, int yWeight) {
        if (constraints == null) {
            System.out.println("Empty constraints!");
            return;
        }
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.weightx = xWeight;
        constraints.weighty = yWeight;
    }
}

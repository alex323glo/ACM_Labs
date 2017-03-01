package Lab_1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alexey_O on 23.02.2017.
 */
public class Resources {
    public static JFrame createJFrame (String formName) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = (Toolkit.getDefaultToolkit()).getScreenSize();
        jFrame.setBounds(dimension.width / 4, dimension.height / 4, dimension.width / 2, dimension.height / 2);
        jFrame.setTitle(formName);
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

    //Clears calculation log
    public static int cleanLog(ArrayList<Double[]> resultList) {
        int len = resultList.size();
        if (len > 0) {
            resultList.clear();
        }
        return len;
    }

    //Returns calculation log as an array of type double[3] (result - matrix)
    public static double[][] getLog(ArrayList<Double[]> resultList) {
        double[][] log = new double[resultList.size()][3];
        for (int i = 0; i < resultList.size(); i++) {
            log[i][0] = (resultList.get(i))[0];
            log[i][1] = (resultList.get(i))[1];
            log[i][2] = (resultList.get(i))[2];
        }
        return log;
    }

    public static String[] getArgsFromFile (String filename) {
        return null;
    }
}

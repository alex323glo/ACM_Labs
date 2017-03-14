package Lab_1;

import javafx.scene.image.*;
import javafx.scene.image.Image;

import javax.swing.*;
import java.awt.*;

public class InfoPart {
    private JFrame jFrame;
    private JPanel jPaneL;
    private Image image;

    public InfoPart() {
        //Assign...
        jFrame = Resources.createJFrame("Info");
        jPaneL = new JPanel();

        //Set or modify...
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jPaneL.setLayout(new GridLayout(3,3));

        //Add to..
        jFrame.add(jPaneL);

        jFrame.revalidate();
    }

    static void setInfoPartElementText(int n) {
        if (n < 0 || n > 1) {
            return;
        }
    }
}

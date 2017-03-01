package Lab_1;

import javax.swing.*;
import java.awt.*;

public class InfoPart {
    private JFrame jFrame;
    private JPanel jPaneL;

    public void showAuthorInfo() {
        //Assign...
        jFrame = Resources.createJFrame("Info");
        jPaneL = new JPanel();


        //Set or modify...
        jPaneL.setLayout(new GridLayout());

        //Add to..

        jFrame.revalidate();
    }
}

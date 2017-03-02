package Lab_1;

import sun.font.FontManager;
import sun.font.FontManagerNativeLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexey_O on 23.02.2017.
 */
public class Main {
    private static JFrame jFrame = Resources.createJFrame("Lab work #1");
    private static JPanel jPanel = new JPanel();
    private static LinePart linePart;
    private static ConditionPart conditionPart;
    private static LoopPart loopPart;

    public static void main(String[] args) {
        //Create elements...
        //Font font = new Font("Times New Roman", Font.ITALIC, 36);
        Font font = new Font("MyFont", Font.ROMAN_BASELINE, 32);
        JTextArea jTextArea = new JTextArea(4,20);
        JMenuBar jMenuBar = new JMenuBar();
        //* ImageIcons:
        ImageIcon imageIconFile = new ImageIcon("Lab1_resources/file24x24.png");
        ImageIcon imageIconParts = new ImageIcon("Lab1_resources/part24x24.png");
        ImageIcon imageIconInfo = new ImageIcon("Lab1_resources/info24x24.png");
        ImageIcon imageIconLinePart = new ImageIcon("Lab1_resources/line24x24.png");
        ImageIcon imageIconConditionPart = new ImageIcon("Lab1_resources/condition24x24.png");
        ImageIcon imageIconLoopPart = new ImageIcon("Lab1_resources/loop24x24.png");
        ImageIcon imageIconAuthor = new ImageIcon("Lab1_resources/author24x24.png");
        ImageIcon imageIconLab = new ImageIcon("Lab1_resources/lab24x24.png");
        ImageIcon imageIconAdditional = new ImageIcon("Lab1_resources/additional24x24.png");
        ImageIcon imageIconExit = new ImageIcon("Lab1_resources/close32x32.png");
        //* Columns:
        JMenu jMenuFile = new JMenu("File");
        JMenu jMenuParts = new JMenu("Parts of task");
        JMenu jMenuInfo = new JMenu("Info");
        //* Menu items:
        JMenuItem jMenuItemExit = new JMenuItem("Exit");
        JMenuItem jMenuItemLinePart = new JMenuItem("Line part");
        JMenuItem jMenuItemConditionPart = new JMenuItem("Condition part");
        JMenuItem jMenuItemLoopPart = new JMenuItem("Loop part");
        JMenuItem jMenuItemInfoAuthor = new JMenuItem("About lab's author");
        JMenuItem jMenuItemInfoLab = new JMenuItem("More about lab work");
        JMenuItem jMenuItemInfoAdditional = new JMenuItem("Additional info");

        //Change or set elements...
        jTextArea.setFont(font);
        jTextArea.add(new JButton("submit"));
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);
        jTextArea.setToolTipText("If you want do find out more about Lab work, Author or some Additional information, try to use \"Info\" menu part!");
        jTextArea.setText("Lab work #1 \nAuthor: Olexiy Orlyuk \nAuthor's group: IP-54 \nAuthor's group-list number: 11");
        jFrame.setJMenuBar(jMenuBar);
        //* Mnemonics:
        jMenuFile.setMnemonic('F');
        jMenuParts.setMnemonic('P');
        jMenuInfo.setMnemonic('I');
        //* Icons:
        jMenuFile.setIcon(imageIconFile);
        jMenuParts.setIcon(imageIconParts);
        jMenuInfo.setIcon(imageIconInfo);
        jMenuItemExit.setIcon(imageIconExit);
        jMenuItemLinePart.setIcon(imageIconLinePart);
        jMenuItemConditionPart.setIcon(imageIconConditionPart);
        jMenuItemLoopPart.setIcon(imageIconLoopPart);
        jMenuItemInfoAuthor.setIcon(imageIconAuthor);
        jMenuItemInfoLab.setIcon(imageIconLab);
        jMenuItemInfoAdditional.setIcon(imageIconAdditional);
        //* Tips:
        //** Columns:
        jMenuFile.setToolTipText("Press to use file settings and actions.");
        jMenuParts.setToolTipText("Press 1 of 3 parts to choose and show window with needed algorithm part (LINE, CONDITION or LOOP part).");
        jMenuInfo.setToolTipText("Press to show Info about work.");
        //** Menu items:
        jMenuItemExit.setToolTipText("Press to EXIT program. \n(All the results and logs won't be saved!)");
        jMenuItemLinePart.setToolTipText("Press to show LINE part of algorithm.");
        jMenuItemConditionPart.setToolTipText("Press to show CONDITION part of algorithm.");
        jMenuItemLoopPart.setToolTipText("Press to show LOOP part of algorithm.");
        jMenuItemInfoAuthor.setToolTipText("Press to view information about lab's author.");
        jMenuItemInfoLab.setToolTipText("Press to learn more about current lab.");
        jMenuItemInfoAdditional.setToolTipText("Press to view additional information.");

        //Add elements to...
        jFrame.add(jTextArea, BorderLayout.CENTER);
        //jFrame.add(new JTextArea(20,5), BorderLayout.WEST);
        //* Columns:
        jMenuBar.add(jMenuFile);  //I have no ideas for this menu column yet...
        jMenuBar.add(jMenuParts);
        jMenuBar.add(jMenuInfo);
        //* Menu items:
        jMenuFile.add(jMenuItemExit);
        jMenuParts.add(jMenuItemLinePart);
        jMenuParts.add(jMenuItemConditionPart);
        jMenuParts.add(jMenuItemLoopPart);
        jMenuInfo.add(jMenuItemInfoAuthor);
        jMenuInfo.add(jMenuItemInfoLab);
        jMenuInfo.add(jMenuItemInfoAdditional);
        //* ActionListeners:
        jMenuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(jFrame, "Do you want to EXIT?", "Exit", JOptionPane.WARNING_MESSAGE) == 0) {
                    System.exit(0);
                }
            }
        });
        jMenuItemLinePart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(jFrame, "Here should be new non-modal window, but it is not ready yet :(", "Imitates Line part window", JOptionPane.PLAIN_MESSAGE);
                linePart = new LinePart();
            }
        });
        jMenuItemConditionPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(jFrame, "Here should be new non-modal window, but it is not ready yet :(", "Imitates Condition part window", JOptionPane.INFORMATION_MESSAGE);
                conditionPart = new ConditionPart();
            }
        });
        jMenuItemLoopPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(jFrame, "Here should be new non-modal window, but it is not ready yet :(", "Imitates Loop part window", JOptionPane.INFORMATION_MESSAGE);
                loopPart = new LoopPart();
            }
        });
        jMenuItemInfoAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, "<Some info about author>", "About author", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jMenuItemInfoLab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, "<Some more info about lab>", "More about Lab", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jMenuItemInfoAdditional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, "<Some additional info>", "Additional info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jFrame.revalidate();
    }
}

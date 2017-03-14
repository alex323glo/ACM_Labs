package Lab_1;

import sun.font.FontManager;
import sun.font.FontManagerNativeLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by Alexey_O on 23.02.2017.
 */
public class Main {

    private static int languageNum = 0;
    //* Main elements
    private static JFrame jFrame;
    private static JPanel jPanel;
    private static Font font;
    private static JTextArea jTextArea;
    private static JMenuBar jMenuBar;
    //* ImageIcons:
    private static ImageIcon imageIconFile;
    private static ImageIcon imageIconParts;
    private static ImageIcon imageIconInfo;
    private static ImageIcon imageIconLinePart;
    private static ImageIcon imageIconConditionPart;
    private static ImageIcon imageIconLoopPart;
    private static ImageIcon imageIconAuthor;
    private static ImageIcon imageIconLab;
    private static ImageIcon imageIconAdditional;
    private static ImageIcon imageIconLanguage;
    private static ImageIcon imageIconEnglish;
    private static ImageIcon imageIconUkrainian;
    private static ImageIcon imageIconExit;
    //* Columns:
    private static JMenu jMenuFile;
    private static JMenu jMenuParts;
    private static JMenu jMenuInfo;
    private static JMenu jMenuFileLanguage;
    //* Menu items:
    //private static JMenuItem jMenuItemLanguage;
    private static JMenuItem jMenuItemEnglish;
    private static JMenuItem jMenuItemUkrainian;
    private static JMenuItem jMenuItemExit;
    private static JMenuItem jMenuItemLinePart;
    private static JMenuItem jMenuItemConditionPart;
    private static JMenuItem jMenuItemLoopPart;
    private static JMenuItem jMenuItemInfoAuthor;
    private static JMenuItem jMenuItemInfoLab;
    private static JMenuItem jMenuItemInfoAdditional;
    //* Parts
    private static LinePart linePart;
    private static ConditionPart conditionPart;
    private static LoopPart loopPart;
    private static InfoPart infoPart;

    public Main() {
        //Create elements...
        jFrame = Resources.createJFrame("Lab work #1");
        jPanel = new JPanel();
        font = new Font("MyFont", Font.ROMAN_BASELINE, 32);
        jTextArea = new JTextArea(4,20);
        jMenuBar = new JMenuBar();
        //* ImageIcons:
        imageIconFile = new ImageIcon("Lab1_resources/file24x24.png");
        imageIconParts = new ImageIcon("Lab1_resources/part24x24.png");
        imageIconInfo = new ImageIcon("Lab1_resources/info24x24.png");
        imageIconLinePart = new ImageIcon("Lab1_resources/line24x24.png");
        imageIconConditionPart = new ImageIcon("Lab1_resources/condition24x24.png");
        imageIconLoopPart = new ImageIcon("Lab1_resources/loop24x24.png");
        imageIconAuthor = new ImageIcon("Lab1_resources/author24x24.png");
        imageIconLab = new ImageIcon("Lab1_resources/lab24x24.png");
        imageIconAdditional = new ImageIcon("Lab1_resources/additional24x24.png");
        imageIconLanguage = new ImageIcon("Lab1_resources/language32x32.png");
        imageIconEnglish = new ImageIcon("Lab1_resources/english24x24.png");
        imageIconUkrainian = new ImageIcon("Lab1_resources/ukrainian24x24.png");
        imageIconExit = new ImageIcon("Lab1_resources/close32x32.png");
        //* Columns:
        jMenuFile = new JMenu("File");
        jMenuParts = new JMenu("Parts of task");
        jMenuInfo = new JMenu("Info");
        jMenuFileLanguage = new JMenu("Language");
        //* Menu items:
        //jMenuItemLanguage = new JMenuItem("Language");
        jMenuItemEnglish = new JMenuItem("English");
        jMenuItemUkrainian = new JMenuItem("Українська");
        jMenuItemExit = new JMenuItem("Exit");
        jMenuItemLinePart = new JMenuItem("Line part");
        jMenuItemConditionPart = new JMenuItem("Condition part");
        jMenuItemLoopPart = new JMenuItem("Loop part");
        jMenuItemInfoAuthor = new JMenuItem("About lab's author");
        jMenuItemInfoLab = new JMenuItem("More about lab work");
        jMenuItemInfoAdditional = new JMenuItem("Additional info");

        //Change or set elements...
        jTextArea.setFont(font);
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);
        jTextArea.setToolTipText("If you want do find out more about Lab work, Author or some Additional information, try to use \"Info\" menu part!");
        jTextArea.setText("Lab work #1 \nAuthor: Olexiy Orlyuk \nAuthor's group: IP-54 \nAuthor's group-list number: 11");
        jFrame.setJMenuBar(jMenuBar);
        //* Mnemonics:
//        jMenuFile.setMnemonic('F');
//        jMenuParts.setMnemonic('P');
//        jMenuInfo.setMnemonic('I');
        //* Icons:
        jMenuFile.setIcon(imageIconFile);
        jMenuParts.setIcon(imageIconParts);
        jMenuInfo.setIcon(imageIconInfo);
        jMenuFileLanguage.setIcon(imageIconLanguage);
        //jMenuItemLanguage.setIcon(imageIconLanguage);
        jMenuItemEnglish.setIcon(imageIconEnglish);
        jMenuItemUkrainian.setIcon(imageIconUkrainian);
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
        jMenuFileLanguage.setToolTipText("Press to change language of program.");
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
        jMenuFile.add(jMenuFileLanguage);
        //* Menu items:
        jMenuFileLanguage.add(jMenuItemEnglish);
        jMenuFileLanguage.add(jMenuItemUkrainian);
        jMenuFile.add(jMenuItemExit);
        jMenuParts.add(jMenuItemLinePart);
        jMenuParts.add(jMenuItemConditionPart);
        jMenuParts.add(jMenuItemLoopPart);
        jMenuInfo.add(jMenuItemInfoAuthor);
        jMenuInfo.add(jMenuItemInfoLab);
        jMenuInfo.add(jMenuItemInfoAdditional);
        //* ActionListeners:
//        jMenuItemLanguage.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                switch((String) JOptionPane.showInputDialog(jFrame, "Choose language", "Language", JOptionPane.OK_CANCEL_OPTION, null, new String[] {"English", "Ukrainian"},"English")) {
//                    case "English":
//                        Resources.resetText(0);
//                        break;
//                    case "Ukrainian":
//                        Resources.resetText(1);
//                        break;
//                }
//            }
//        });
        jMenuItemEnglish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                languageNum = 0;
                Resources.resetText(languageNum);
            }
        });
        jMenuItemUkrainian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                languageNum = 1;
                Resources.resetText(languageNum);
            }
        });
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
                linePart = new LinePart(languageNum);
            }
        });
        jMenuItemConditionPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(jFrame, "Here should be new non-modal window, but it is not ready yet :(", "Imitates Condition part window", JOptionPane.INFORMATION_MESSAGE);
                conditionPart = new ConditionPart(languageNum);
            }
        });
        jMenuItemLoopPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(jFrame, "Here should be new non-modal window, but it is not ready yet :(", "Imitates Loop part window", JOptionPane.INFORMATION_MESSAGE);
                loopPart = new LoopPart(languageNum);
            }
        });
        jMenuItemInfoAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, "Some additional info about lab's author:\n" + "City: Kyiv, Ukraine.\n"+ "Email: alex323glo@gmail.com .\n" + "Tel: +38-068-868-08-42.", "About author", JOptionPane.INFORMATION_MESSAGE);
                //infoPart = new InfoPart();
            }
        });
        jMenuItemInfoLab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, "This lab work was about different types of \nalgorithms and their specific realisation.", "More about Lab", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jMenuItemInfoAdditional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, "Next lab works will be done either by making integration \ninto this project or using Android platform tools.", "Additional info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jFrame.revalidate();
    }

    static void setMainElementText(int n) {
        if (n < 0 || n > 1) {
            return;
        }
        Map<String,String[]> map = Resources.mainMap;
        jFrame.setTitle(map.get("jFrame")[n]);
        jTextArea.setText(map.get("jTextArea")[n]);
        //* Columns:
        jMenuFile.setText(map.get("jMenuFile")[n]);
        jMenuParts.setText(map.get("jMenuParts")[n]);
        jMenuInfo.setText(map.get("jMenuInfo")[n]);
        jMenuFileLanguage.setText(map.get("jMenuFileLanguage")[n]);
        //* Menu items:
        jMenuItemExit.setText(map.get("jMenuItemExit")[n]);
        jMenuItemLinePart.setText(map.get("jMenuItemLinePart")[n]);
        jMenuItemConditionPart.setText(map.get("jMenuItemConditionPart")[n]);
        jMenuItemLoopPart.setText(map.get("jMenuItemLoopPart")[n]);
        jMenuItemInfoAuthor.setText(map.get("jMenuItemInfoAuthor")[n]);
        jMenuItemInfoLab.setText(map.get("jMenuItemInfoLab")[n]);
        jMenuItemInfoAdditional.setText(map.get("jMenuItemInfoAdditional")[n]);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}

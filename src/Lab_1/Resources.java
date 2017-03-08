package Lab_1;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexey_O on 23.02.2017.
 */

public class Resources {
    public static final Map<String, String[]> mainMap = createMainMap();
    public static final Map<String, String[]> lineMap = createLineMap();
    public static final Map<String, String[]> condMap = createCondMap();
    public static final Map<String, String[]> loopMap = createLoopMap();
    public static final Map<String, String[]> infoMap = createInfoMap();

    static private Map<String,String[]> createMainMap() {
        Map<String,String[]> map = new HashMap<>();
        map.put("jFrame", new String[] {"Lab work #1", "Лабораторна робота №1"});
        //map.put("jPanel", new String[] {"", ""});
        map.put("jTextArea", new String[] {"Lab work #1\n" + "Author: Olexiy Orlyuk\n" + "Author's group: IP-54 \n" + "Author's group-list number: 11", "Лабораторна робота №1\n" + "Автор: Олексій Орлюк\n" + "Група: ІП-54 \n" + "Номер за списком групи: 11"});
        map.put("jMenuFile", new String[] {"File", "Файл"});
        map.put("jMenuParts", new String[] {"Parts of task", "Частини завдання"});
        map.put("jMenuInfo", new String[] {"Info", "Інформація"});
        map.put("jMenuFileLanguage", new String[] {"Language", "Мова"});
        map.put("jMenuItemExit", new String[] {"Exit", "Вийти"});
        map.put("jMenuItemLinePart", new String[] {"Line part", "Лінійний"});
        map.put("jMenuItemConditionPart", new String[] {"Condition part", "Розгалужений"});
        map.put("jMenuItemLoopPart", new String[] {"Loop part", "Циклічний"});
        map.put("jMenuItemInfoAuthor", new String[] {"About lab's author", "Про автора"});
        map.put("jMenuItemInfoLab", new String[] {"More about lab work", "Більше про лаб. роботу"});
        map.put("jMenuItemInfoAdditional", new String[] {"Additional info", "Додаткова інформація"});
        return map;
    }
    static private Map<String,String[]> createLineMap() {
        Map<String,String[]> map = new HashMap<>();

        return map;
    }
    static private Map<String,String[]> createCondMap() {
        Map<String,String[]> map = new HashMap<>();

        return map;
    }
    static private Map<String,String[]> createLoopMap() {
        Map<String,String[]> map = new HashMap<>();

        return map;
    }
    static private Map<String,String[]> createInfoMap() {
        Map<String,String[]> map = new HashMap<>();

        return map;
    }

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

    private static String[] getArgsFromFile (File file) {
        String[] strings = null;
        String fileText = "";
        try {
            if (file.exists() == false) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                fileText += (bufferedReader.readLine() + " ");
            }
            strings = parseText(fileText);
        } catch (FileNotFoundException e1) {
            System.out.println("FileNotFoundException! "/* + e1.getStackTrace()*/);
        } catch (Exception e) {
            //Some actions...
        } finally {
            return strings;
        }
    }

    //Parses string on words, devided by <space> symbol
    private static String[] parseText (String text) {
        String[] newText = text.split(" ");
        String[] newText2 = new String[newText.length];
        for (int i=0, j=0; i < newText.length; i++) {
            if (newText[i].length() != 0) {
                newText2[j] = newText[i];
                j++;
            }
        }
        return newText2;
    }

    public static void chooseArgsFromFile (JFrame jFrame, JTextField jTextField1, JTextField jTextField2) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(jFrame) == 1) {return;}
            String[] digits = getArgsFromFile(fileChooser.getSelectedFile());
            if (digits.length < 2) {
                JOptionPane.showMessageDialog(jFrame, "Wrong arguments were written from file!", "File read error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String arg1 = (String) JOptionPane.showInputDialog(jFrame, "Choose argument #1", "Select #1", JOptionPane.OK_CANCEL_OPTION, null, digits, null);
            if (arg1 == null) {return;}
            jTextField1.setText(arg1);
            String arg2 = (String) JOptionPane.showInputDialog(jFrame, "Choose argument #2", "Select #2", JOptionPane.OK_CANCEL_OPTION, null, digits, null);
            if (arg2 == null) {return;}
            jTextField2.setText(arg2);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException!\n" + e.getStackTrace());
        }
    }

    static void resetText(int n) {
        if (n < 0 || n > 1) {
            return;
        }
        ConditionPart.setConditionPartElementText(n);
        InfoPart.setInfoPartElementText(n);
        LinePart.setLinePartElementText(n);
        LoopPart.setLoopPartElementText(n);
        Main.setMainElementText(n);
    }
}

package Lab_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Alexey_O on 23.02.2017.
 */
public class ConditionPart {
    private ArrayList<Double[]> results = new ArrayList<Double[]>();
    private JFrame jFrame;
    private JButton jButtonCalc;
    private JButton jButtonShow;
    private JButton jButtonClean;
    private JButton jButtonReadFile;
    private JTextField jTextFieldK;
    private JTextField jTextFieldX;
    private JPanel jPanelFields;
    private JPanel jPanelResult;
    private JLabel jLabelK;
    private JLabel jLabelX;
    private JLabel jLabelResult;
    private JLabel jLabelImage;
    private ImageIcon imageFormula;
    GridBagLayout gridBagLayout;
    GridBagConstraints constraintsImage;
    GridBagConstraints constraintsResult;

    public ConditionPart (int language) {
        //Init elements...
        jFrame = Resources.createJFrame("Condition part");
        gridBagLayout = new GridBagLayout();
        constraintsImage = new GridBagConstraints();
        constraintsResult = new GridBagConstraints();
        //* JButtons:
        jButtonCalc = new JButton("Calculate");
        jButtonShow = new JButton("Show");
        jButtonClean = new JButton("Clean");
        jButtonReadFile = new JButton("(...)");
        //* JTextFields:
        jTextFieldK = new JTextField(12);
        jTextFieldX = new JTextField(12);
        //* JPanels and JLabel:
        jPanelFields = new JPanel();
        jPanelResult = new JPanel();
        jLabelK = new JLabel("K argument: ");
        jLabelX = new JLabel("X argument: ");
        jLabelResult = new JLabel(" = <result>");
        jLabelImage = new JLabel("");
        imageFormula = new ImageIcon("Lab1_resources/formulaCond.png");

        //Change or set elements...
        Resources.fixConstraint(constraintsImage, 0, 3, 1, 5, 0, 0);
        Resources.fixConstraint(constraintsResult, 0, 13, 5, 5, 0, 0);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jPanelResult.setLayout(gridBagLayout);
        jLabelImage.setIcon(imageFormula);
        jLabelResult.setFont(new Font("MyFont", Font.BOLD, 24));

        //Add elements to...
        //* Add to JFrame:
        jFrame.add(jButtonCalc, BorderLayout.WEST);
        jFrame.add(jButtonShow, BorderLayout.SOUTH);
        jFrame.add(jButtonClean, BorderLayout.EAST);
        jFrame.add(jPanelFields, BorderLayout.NORTH);
        jFrame.add(jPanelResult, BorderLayout.CENTER);
        //* Add to JPanels:
        jPanelFields.add(jLabelK);
        jPanelFields.add(jTextFieldK);
        jPanelFields.add(jLabelX);
        jPanelFields.add(jTextFieldX);
        jPanelFields.add(jButtonReadFile);
        jPanelResult.add(jLabelImage, constraintsImage);
        jPanelResult.add(jLabelResult, constraintsResult);
        //* Add ActionListeners:
        jButtonReadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Resources.chooseArgsFromFile(jFrame, jTextFieldK, jTextFieldX);
            }
        });
        jButtonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double dK = Double.parseDouble(jTextFieldK.getText());
                    double dX = Double.parseDouble(jTextFieldX.getText());
                    if (dK <= 0 || dX <= 0) {
                        JOptionPane.showMessageDialog(jFrame, "Wrong argument was entered! Please, enter arguments, which are bigger then 0!","Wrong arguments", JOptionPane.ERROR_MESSAGE);
                        jTextFieldK.setText("");
                        jTextFieldX.setText("");
                        return;
                    }
                    jLabelResult.setText(" = " + calculate(dK, dX));
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(jFrame, "Wrong argument was entered! Please, enter arguments, which include only decimal digits!","Wrong arguments", JOptionPane.ERROR_MESSAGE);
                    jTextFieldK.setText("");
                    jTextFieldX.setText("");
                    nfe.getStackTrace();
                }
            }
        });
        jButtonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( JOptionPane.showConfirmDialog(jFrame, "Are you sure yo want to clean (delete whole) CALCULATION LOG? \nIt contains " + results.size() + " elements at the moment!", "Clean log", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == 0) {
                    jTextFieldK.setText("");
                    jTextFieldX.setText("");
                    jLabelResult.setText("<result>");
                    JOptionPane.showMessageDialog(jFrame, Resources.cleanLog(results) + " elements have been cleaned successfully!", "Clean log", JOptionPane.OK_OPTION);
                }
            }
        });
        jButtonShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, getLogString(), "Calculation log", JOptionPane.PLAIN_MESSAGE);
            }
        });

        jFrame.revalidate();
    }

    //Calculates result value and turns it to string
    private String calculate (double k, double x) {
        double result = k * Math.pow(x,2) * Math.log10(k * x) + Math.sqrt(x);
        results.add(new Double[]{k, x, result});
        String str = new String();
        Double d = new Double(result);
        str = d.toString();
        return str;
    }

    //returns String form : "<Arg1> ; <Arg2> ; <Result>"
    private String getLogString() {
        if (results.size() < 1) {
            return "Log is empty!";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("K arg ; X arg ; Result \n");
        for (int i = 0; i < results.size(); i++) {
            stringBuilder.append((results.get(i))[0].toString() + "; ");
            stringBuilder.append((results.get(i))[1].toString() + "; ");
            stringBuilder.append((results.get(i))[2].toString() + " \n");
        }
        String string = new String(stringBuilder);
        return string;
    }

    static void setConditionPartElementText(int n) {
        if (n < 0 || n > 1) {
            return;
        }
    }
}

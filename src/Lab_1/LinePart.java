package Lab_1;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Alexey_O on 23.02.2017.
 */
public class LinePart {
    private ArrayList<Double[]> results = new ArrayList<Double[]>();
    private JFrame jFrame;
    private JButton jButtonCalc;
    private JButton jButtonShow;
    private JButton jButtonClean;
    private JButton jButtonReadFile;
    private JTextField jTextFieldA;
    private JTextField jTextFieldB;
    private JPanel jPanelFields;
    private JPanel jPanelResult;
    private JLabel jLabelA;
    private JLabel jLabelB;
    private JLabel jLabelResult;
    private JLabel jLabelImage;
    private ImageIcon imageFormula;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints constraintsImage;
    private GridBagConstraints constraintsResult;

    public LinePart() {
        //Init elements...
        jFrame = Resources.createJFrame("Line part");
        gridBagLayout = new GridBagLayout();
        constraintsImage = new GridBagConstraints();
        constraintsResult = new GridBagConstraints();
        //* JButtons:
        jButtonCalc = new JButton("Calculate");
        jButtonShow = new JButton("Show");
        jButtonClean = new JButton("Clean");
        jButtonReadFile = new JButton("(...)");
        //* JTextFields:
        jTextFieldA = new JTextField(12);
        jTextFieldB = new JTextField(12);
        //* JPanels and JLabel:
        jPanelFields = new JPanel();
        jPanelResult = new JPanel();
        jLabelA = new JLabel("A argument: ");
        jLabelB = new JLabel("B argument: ");
        jLabelResult = new JLabel(" = <result>");
        jLabelImage = new JLabel("");
        imageFormula = new ImageIcon("Lab1_resources/formulaLine.png");

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
        jPanelFields.add(jLabelA);
        jPanelFields.add(jTextFieldA);
        jPanelFields.add(jLabelB);
        jPanelFields.add(jTextFieldB);
        jPanelFields.add(jButtonReadFile);
        jPanelResult.add(jLabelImage, constraintsImage);
        jPanelResult.add(jLabelResult, constraintsResult);
        //* Add ActionListeners:
        jButtonReadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Resources.chooseArgsFromFile(jFrame, jTextFieldA, jTextFieldB);
            }
        });
        jButtonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double dA = Double.parseDouble(jTextFieldA.getText()) % 37.69911184;
                    double dB = Double.parseDouble(jTextFieldB.getText()) % 37.69911184;
                    if (dA < 0 || dA > 18.84955592 || dB < -9.42477796 || dB > 9.42477796) {
                        JOptionPane.showMessageDialog(jFrame, "Wrong argument was entered! \nPlease, enter arguments, which are: \n1) A = (12 *PI * n .. 6 * PI + 12 * PI * n); \n2) B = (-3 * PI + 12 *PI * n .. 3 * PI + 12 * PI * n), \nwhere n belongs to Z-numbers.","Wrong arguments", JOptionPane.ERROR_MESSAGE);
                        jTextFieldA.setText("");
                        jTextFieldB.setText("");
                        return;
                    }
                    jLabelResult.setText(" = " + calculate(dA, dB));
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(jFrame, "Wrong arguments were entered! Please, enter arguments, which include only decimal digits!","Wrong arguments", JOptionPane.ERROR_MESSAGE);
                    jTextFieldA.setText("");
                    jTextFieldB.setText("");
                    nfe.getStackTrace();
                }
            }
        });
        jButtonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( JOptionPane.showConfirmDialog(jFrame, "Are you sure yo want to clean (delete whole) CALCULATION LOG? \nIt contains " + results.size() + " elements at the moment!", "Clean log", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == 0) {
                    jTextFieldA.setText("");
                    jTextFieldB.setText("");
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
    private String calculate (double a, double b) {
        double part1 = Math.sin((a/6) % 6.28318530);
        double part2 = Math.cos((b/6) % 6.28318530);
        System.out.println(part1 + " ;\n" + part2);
        double result = Math.sqrt( part1 + part2 ) + Math.sqrt(2 * part1 * part2);
        results.add(new Double[]{a,b,result});
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
        stringBuilder.append("A arg ; B arg ; Result \n");
        for (int i = 0; i < results.size(); i++) {
            stringBuilder.append((results.get(i))[0].toString() + "; ");
            stringBuilder.append((results.get(i))[1].toString() + "; ");
            stringBuilder.append((results.get(i))[2].toString() + " \n");
        }
        String string = new String(stringBuilder);
        return string;
    }
}

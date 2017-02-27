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
    private JTextField jTextFieldA;
    private JTextField jTextFieldB;
    private JPanel jPanelFields;
    private JPanel jPanelResult;
    private JLabel jLabelA;
    private JLabel jLabelB;
    private JLabel jLabelResult;
    private JLabel jLabelImage;
    private ImageIcon imageFormula;
    GridBagLayout gridBagLayout;
    GridBagConstraints constraintsImage;
    GridBagConstraints constraintsResult;

    public LinePart() {
        gridBagLayout = new GridBagLayout();
        constraintsImage = new GridBagConstraints();
        constraintsResult = new GridBagConstraints();
        //Init elements...
        jFrame = Resources.createJFrame();
        //* JButtons:
        jButtonCalc = new JButton("Calculate");
        jButtonShow = new JButton("Show");
        jButtonClean = new JButton("Clean");
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
        imageFormula = new ImageIcon("Lab1_resources/formula.png");

        //Change or set elements...
        Resources.fixConstraint(constraintsImage, 0, 3, 1, 5, 0, 0);
        Resources.fixConstraint(constraintsResult, 0, 13, 5, 5, 0, 0);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jPanelResult.setLayout(gridBagLayout);
        jLabelImage.setIcon(imageFormula);
        jLabelResult.setFont(new Font("Times New Roman", Font.BOLD, 24));

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
        jPanelResult.add(jLabelImage, constraintsImage);
        jPanelResult.add(jLabelResult, constraintsResult);
        //* Add ActionListeners:
        jButtonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double dA = Double.parseDouble(jTextFieldA.getText());
                    double dB = Double.parseDouble(jTextFieldB.getText());
                    if (dA < -6 || dA >6 || dB < -6 || dB > 6) {
                        JOptionPane.showMessageDialog(jFrame, "Wrong argument was entered! Please, enter arguments, which are bigger then -6 and smaller then 6!","Wrong arguments", JOptionPane.ERROR_MESSAGE);
                        jTextFieldA.setText("A argument: ");
                        jTextFieldB.setText("B argument: ");
                        return;
                    }
                    jLabelResult.setText(" = " + calculate(dA, dB));
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(jFrame, "Wrong argument was entered! Please, enter arguments, which include only decimal digits!","Wrong arguments", JOptionPane.ERROR_MESSAGE);
                    jTextFieldA.setText("A argument: ");
                    jTextFieldB.setText("B argument: ");
                    nfe.getStackTrace();
                }
            }
        });
        jButtonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, "Here should be performed clean log action, but it is not ready yet :(", "Imitates work of \"Clean\" button", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jButtonShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, "Here should be performed show log action, but it is not ready yet :(", "Imitates work of \"Show\" button", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jFrame.revalidate();
    }

    //Shows window of Line part
    public void visualise() {
        System.out.println("(1; 1) Result = " + calculate(1,1));
        System.out.println("(3; 3) Result = " + calculate(3,3));
        System.out.println("(6; 6) Result = " + calculate(6,6));
    }

    //Calculates result value and turns it to string
    private String calculate (double a, double b) {
        double part1 = Math.sin(a/6);
        double part2 = Math.cos(b/6);
        double result = Math.sqrt( part1 + part2 ) + Math.sqrt(2 * part1 * part2);
        results.add(new Double[]{a,b,result});
        String str = new String();
        Double d = new Double(result);
        str = d.toString();
        return str;
    }

    //Returns calculation log as an array of type double[3] (result - matrix)
    private double[][] getLog() {
        double[][] log = new double[results.size()][3];
        for (int i = 0; i < results.size(); i++) {
            log[i][0] = (results.get(i))[0];
            log[i][1] = (results.get(i))[1];
            log[i][2] = (results.get(i))[2];
        }
        return log;
    }

    //Clears calculation log
    private int clearLog() {
        int len = results.size();
        if (len > 0) {
            results.clear();
        }
        return len;
    }
}

package Lab_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Alexey_O on 23.02.2017.
 */
public class LoopPart {
    private ArrayList<Double[]> results = new ArrayList<Double[]>();
    private JFrame jFrame;
    private JButton jButtonCalc;
    private JButton jButtonShow;
    private JButton jButtonClean;
    private JButton jButtonReadFile;
    private JTextField jTextFieldN;
    private JTextField jTextFieldB;
    private JPanel jPanelFields;
    private JPanel jPanelResult;
    private JLabel jLabelN;
    private JLabel jLabelB;
    private JLabel jLabelResult;
    private JLabel jLabelImage;
    private ImageIcon imageFormula;
    GridBagLayout gridBagLayout;
    GridBagConstraints constraintsImage;
    GridBagConstraints constraintsResult;

    public LoopPart() {
        //Init elements...
        jFrame = Resources.createJFrame("Loop part");
        gridBagLayout = new GridBagLayout();
        constraintsImage = new GridBagConstraints();
        constraintsResult = new GridBagConstraints();
        //* JButtons:
        jButtonCalc = new JButton("Calculate");
        jButtonShow = new JButton("Show");
        jButtonClean = new JButton("Clean");
        jButtonReadFile = new JButton("(...)");
        //* JTextFields:
        jTextFieldN = new JTextField(12);
        jTextFieldB = new JTextField(12);
        //* JPanels and JLabel:
        jPanelFields = new JPanel();
        jPanelResult = new JPanel();
        jLabelN = new JLabel("N argument: ");
        jLabelB = new JLabel("B argument: ");
        jLabelResult = new JLabel(" = <result>");
        jLabelImage = new JLabel("");
        imageFormula = new ImageIcon("Lab1_resources/formulaLoop.png");

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
        jPanelFields.add(jLabelN);
        jPanelFields.add(jTextFieldN);
        jPanelFields.add(jLabelB);
        jPanelFields.add(jTextFieldB);
        jPanelFields.add(jButtonReadFile);
        jPanelResult.add(jLabelImage, constraintsImage);
        jPanelResult.add(jLabelResult, constraintsResult);
        //* Add ActionListeners:
        jButtonReadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Resources.chooseArgsFromFile(jFrame, jTextFieldN, jTextFieldB);
            }
        });
        jButtonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long lN = Long.parseLong(jTextFieldN.getText());
                    double dB = Double.parseDouble(jTextFieldB.getText());
                    if (lN < 1) {
                        JOptionPane.showMessageDialog(jFrame, "Wrong argument was entered! Please, enter argument N, which is bigger then 1!","Wrong arguments", JOptionPane.ERROR_MESSAGE);
                        jTextFieldN.setText("");
                        jTextFieldB.setText("");
                        return;
                    }
                    jLabelResult.setText(" = " + calculate(lN, dB));
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(jFrame, "Wrong arguments were entered! \nPlease, enter arguments, which include only decimal digits and \nN argument must not be a floating point type number!","Wrong arguments", JOptionPane.ERROR_MESSAGE);
                    jTextFieldN.setText("");
                    jTextFieldB.setText("");
                    nfe.getStackTrace();
                }
            }
        });
        jButtonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( JOptionPane.showConfirmDialog(jFrame, "Are you sure yo want to clean (delete whole) CALCULATION LOG? \nIt contains " + results.size() + " elements at the moment!", "Clean log", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == 0) {
                    jTextFieldN.setText("");
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

    //Shows window of Line part
    public void visualise() {
        System.out.println("(1; 1) Result = " + calculate(1,1));
        System.out.println("(3; 3) Result = " + calculate(3,3));
        System.out.println("(6; 6) Result = " + calculate(6,6));
    }

    //Calculates result value and turns it to string
    private String calculate (long n, double b) {
        double result = 1, sum = 0;
        for (int a = 1; a <= n; a++) {
            for (int k = 1; k <= a; k++) {
                sum += ( (double) Math.pow(a,k) ) + (b / ( (double) k));
            }
            result *= sum;
            sum = 0;
        }
        results.add(new Double[]{((double) n),b,result});
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
        stringBuilder.append("N arg ; B arg ; Result \n");
        int longN = 0;
        for (int i = 0; i < results.size(); i++) {
            longN = (int) ( (double) (results.get(i))[0] );
            stringBuilder.append(longN + "; ");
            stringBuilder.append((results.get(i))[1].toString() + "; ");
            stringBuilder.append((results.get(i))[2].toString() + " \n");
        }
        String string = new String(stringBuilder);
        return string;
    }

    static void setLoopPartElementText(int n) {

    }
}

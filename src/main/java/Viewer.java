import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;

/**
 * Copyright (C) 2020 Intern Labs O!
 * <p>
 * Calculator program executed in Java and Swing with MVC template
 * Main function:
 * This program repeats the basic functions of the Windows Calculator in "Normal" mode
 * with the ability to calculate examples where there are brackets.
 * Calculations are performed using the logic of reverse Polish notation.
 * Its possibility:
 * addition, subtraction, multiplication,division,parentheses,
 * integers and fractions, clearing the screen.
 * You can enter data using the app's buttons.
 *
 * @author Argen Kasymov
 */


/**
 * The Viewer class draws the program's graphics. The Viewer receives data and displays it on the screen.
 */
public class Viewer {

    private JTextField textField, answerField, infixField;
    private JLabel errorShowLabel, postfixShowLabel;


    /**
     * Viewer Constructor:
     * Initialized: a controller with a reference to this class
     * model instance from the controller
     * canvas instance with reference to the model
     * The rest is the program's graphical interface.
     */
    public Viewer() {

        Controller controller = new Controller(this);

        postfixShowLabel = new JLabel("", SwingConstants.RIGHT);
        postfixShowLabel.setBounds(0, 5, 350, 25);

        infixField = new JTextField("");
        infixField.setFont(new java.awt.Font("Alergia", java.awt.Font.ITALIC, 20));
        infixField.setBounds(0, 35, 350, 30);
        infixField.setBorder(new LineBorder(new Color(255, 255, 255)));
        infixField.setHorizontalAlignment(JTextField.RIGHT);

        answerField = new JTextField("");
        answerField.setFont(new java.awt.Font("Alergia", java.awt.Font.ITALIC, 20));
        answerField.setForeground(Color.CYAN);
        answerField.setHorizontalAlignment(JTextField.RIGHT);
        answerField.setBorder(new LineBorder(new Color(255, 255, 255)));
        answerField.setBounds(0, 70, 350, 30);

        textField = new JTextField("");
        textField.setFont(new java.awt.Font("Alergia", java.awt.Font.ITALIC, 20));
        textField.setBorder(new LineBorder(new Color(255, 255, 255)));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBounds(0, 105, 350, 30);

        errorShowLabel = new JLabel("");
        errorShowLabel.setBounds(0, 135, 350, 15);
        errorShowLabel.setForeground(Color.RED);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
        editorPane.setBounds(25, 25, 350, 150);
        editorPane.add(postfixShowLabel);
        editorPane.add(infixField);
        editorPane.add(answerField);
        editorPane.add(textField);
        editorPane.add(errorShowLabel);

        JPanel panel = getCenterJPanel(controller);
        panel.setBounds(25, 190, 350, 200);

        JFrame frame = new JFrame("Calculator - Reverse Polish Notation");
        frame.setSize(420, 470);
        frame.setLocation(100, 50);
        frame.setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.getContentPane().add(editorPane);
        frame.add(panel);
        frame.setVisible(true);
    }


    /**
     * Central button panel
     * Contains buttons for the digits from 0 - 9
     * As well as operator buttons" +", "-", "*", "/"
     * For long examples, " ("and ")"
     * There are also output buttons for"=",
     * "C" for clearing the input field, and "," for real numbers
     */
    private JPanel getCenterJPanel(Controller controller) {

        JButton buttonDelete = new JButton("c");
        buttonDelete.setBounds(0, 0, 175, 30);
        buttonDelete.addActionListener(controller);
        buttonDelete.setActionCommand("Clear");

        JButton buttonClear = new JButton("(");
        buttonClear.setBounds(310, 35, 40, 60);
        buttonClear.addActionListener(controller);
        buttonClear.setActionCommand("(");

        JButton buttonPercent = new JButton(")");
        buttonPercent.setBounds(310, 100, 40, 65);
        buttonPercent.addActionListener(controller);
        buttonPercent.setActionCommand(")");

        JButton buttonSeven = new JButton("7");
        buttonSeven.setBounds(0, 125, 55, 40);
        buttonSeven.setForeground(Color.magenta);
        buttonSeven.addActionListener(controller);
        buttonSeven.setActionCommand("7");

        JButton buttonEight = new JButton("8");
        buttonEight.setBounds(60, 125, 55, 40);
        buttonEight.setForeground(Color.magenta);
        buttonEight.addActionListener(controller);
        buttonEight.setActionCommand("8");

        JButton buttonNine = new JButton("9");
        buttonNine.setBounds(120, 125, 55, 40);
        buttonNine.setForeground(Color.magenta);
        buttonNine.addActionListener(controller);
        buttonNine.setActionCommand("9");

        JButton buttonDivide = new JButton("/");
        buttonDivide.setBounds(245, 100, 60, 65);
        buttonDivide.addActionListener(controller);
        buttonDivide.setActionCommand("/");

        JButton buttonFour = new JButton("4");
        buttonFour.setBounds(0, 80, 55, 40);
        buttonFour.setForeground(Color.magenta);
        buttonFour.addActionListener(controller);
        buttonFour.setActionCommand("4");

        JButton buttonFive = new JButton("5");
        buttonFive.setBounds(60, 80, 55, 40);
        buttonFive.setForeground(Color.magenta);
        buttonFive.addActionListener(controller);
        buttonFive.setActionCommand("5");

        JButton buttonSix = new JButton("6");
        buttonSix.setBounds(120, 80, 55, 40);
        buttonSix.setForeground(Color.magenta);
        buttonSix.addActionListener(controller);
        buttonSix.setActionCommand("6");

        JButton buttonMultiplication = new JButton("*");
        buttonMultiplication.setBounds(180, 100, 60, 65);
        buttonMultiplication.addActionListener(controller);
        buttonMultiplication.setActionCommand("*");


        JButton buttonOne = new JButton("1");
        buttonOne.setBounds(0, 35, 55, 40);
        buttonOne.setForeground(Color.magenta);
        buttonOne.addActionListener(controller);
        buttonOne.setActionCommand("1");

        JButton buttonTwo = new JButton("2");
        buttonTwo.setBounds(60, 35, 55, 40);
        buttonTwo.setForeground(Color.magenta);
        buttonTwo.addActionListener(controller);
        buttonTwo.setActionCommand("2");

        JButton buttonThree = new JButton("3");
        buttonThree.setBounds(120, 35, 55, 40);
        buttonThree.setForeground(Color.magenta);
        buttonThree.addActionListener(controller);
        buttonThree.setActionCommand("3");

        JButton buttonZero = new JButton("0");
        buttonZero.setBounds(0, 170, 175, 30);
        buttonZero.setForeground(Color.magenta);
        buttonZero.addActionListener(controller);
        buttonZero.setActionCommand("0");

        JButton buttonComma = new JButton(",");
        buttonComma.setBounds(180, 170, 170, 30);
        buttonComma.addActionListener(controller);
        buttonComma.setActionCommand(".");

        JButton buttonPlus = new JButton("+");
        buttonPlus.setBounds(180, 35, 60, 60);
        buttonPlus.addActionListener(controller);
        buttonPlus.setActionCommand("+");

        JButton buttonMinus = new JButton("-");
        buttonMinus.setBounds(245, 35, 60, 60);
        buttonMinus.addActionListener(controller);
        buttonMinus.setActionCommand("-");

        JButton buttonEqually = new JButton("=");
        buttonEqually.setBounds(180, 0, 170, 30);
        buttonEqually.addActionListener(controller);
        buttonEqually.setActionCommand("=");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.add(buttonDelete);

        panel.add(buttonSeven);
        panel.add(buttonEight);
        panel.add(buttonNine);
        panel.add(buttonDivide);

        panel.add(buttonFour);
        panel.add(buttonFive);
        panel.add(buttonSix);
        panel.add(buttonMultiplication);
        panel.add(buttonPercent);

        panel.add(buttonOne);
        panel.add(buttonTwo);
        panel.add(buttonThree);
        panel.add(buttonMinus);
        panel.add(buttonEqually);

        panel.add(buttonZero);
        panel.add(buttonComma);
        panel.add(buttonPlus);
        panel.add(buttonClear);

        return panel;
    }


    /**
     * Updates text
     */
    public void update(String value) {
        textField.setText(value);
    }


    /**
     * deletes all data from the screen
     */
    public void clearTextField() {
        textField.setText("");
        postfixShowLabel.setText("");
        answerField.setText("");
        infixField.setText("");
        errorShowLabel.setText("");
    }


    /**
     * displays the Postfix value
     */
    public void setPostfix(String s) {
        postfixShowLabel.setText("Postfix : " + s);
    }


    /**
     * displays the Infix value
     */
    public void setInfix(String s) {
        infixField.setText(s);
    }


    /**
     * displays the Answer
     */
    public void setAnswer(String s) {
        answerField.setText(s);
    }


    /**
     * displays the Error
     */
    public void setErrorCheck(String s) {
        errorShowLabel.setText("note :" + s);
    }
}

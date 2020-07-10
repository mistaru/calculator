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
 * The Model class manages data and program logic.
 * In the class, the Model is initialized by the Viewer to send data directly to the Viewer
 */
public class Model {

    private final Viewer viewer;
    private String temp;
    private final PostFixCalculator calc;
    private int checkLogic;
    private int checkBrackets;


    /**
     * constructor of the Model class
     * Initializing the Viewer and PostFixCalculator in the constructor
     */
    public Model(Viewer viewer) {
        this.viewer = viewer;
        calc = new PostFixCalculator();
        temp = "";
        checkLogic = 0;
        checkBrackets = 0;

    }


    /**
     * doAction
     * Basic logic of the program
     * The controller sends a command,
     * the model examines it, and when detected,
     * performs this action,
     * after which the break statement is called
     * @param value stores the command name
     */
    public void doAction(String value) {
        switch (value) {
            case ("="):
                if (checkBrackets == 0 && checkLogic == 1) {

                    String postfix = ReversePolishNotation.reverseString(temp);
                    double decimalValue = calc.calculate(postfix);
                    String answer = String.valueOf(decimalValue);
                    viewer.setInfix(temp);
                    viewer.setPostfix(postfix);
                    viewer.setAnswer(answer);
                    viewer.setErrorCheck("0");
                    temp = "";
                    checkLogic = 0;
                    checkBrackets = 0;
                    viewer.update("");
                } else {
                    viewer.setErrorCheck("you forgot any symbol...");
                }
                break;

            case ("Clear"):
                System.out.println("You have cleared everything ... ");
                viewer.clearTextField();
                temp = "";
                checkLogic = 0;
                checkBrackets = 0;
                break;

            case ("."):
                if (checkLogic == 0) {
                    viewer.setErrorCheck("Pleas enter other button");
                    break;
                } else if (checkLogic == 1) {
                    temp += value;
                    viewer.update(temp);
                    checkLogic = 0;
                    break;
                }

            case ("+"):
                if (checkLogic == 0) {
                    if (!temp.equals("")) {
                        temp = temp.substring(0, temp.length() - 1);
                        temp += "+";
                        viewer.update(temp);
                    } else {
                        viewer.setErrorCheck("you can't use as format .Pleas enter other button");
                    }
                    break;
                } else if (checkLogic == 1) {
                    temp += value;
                    viewer.update(temp);
                    checkLogic = 0;
                    break;
                }
            case ("-"):
                if (checkLogic == 0) {
                    if (temp.equals("")) {
                        viewer.setErrorCheck("Pleas enter other button");
                    } else {
                        temp = temp.substring(0, temp.length() - 1);
                        temp += "-";
                        viewer.update(temp);
                    }
                    break;
                } else if (checkLogic == 1) {
                    temp += value;
                    viewer.update(temp);
                    checkLogic = 0;
                    break;
                }
            case ("*"):
                if (checkLogic == 0) {
                    if (temp.equals("")) {
                        viewer.setErrorCheck("Pleas enter other button");
                    } else {
                        temp = temp.substring(0, temp.length() - 1);
                        temp += "*";
                        viewer.update(temp);
                    }
                    break;
                } else if (checkLogic == 1) {
                    temp += value;
                    viewer.update(temp);
                    checkLogic = 0;
                    break;
                }
            case ("/"):
                if (checkLogic == 0) {
                    if (temp.equals("")) {
                        viewer.setErrorCheck("Pleas enter other button");
                    } else {
                        temp = temp.substring(0, temp.length() - 1);
                        temp += "/";
                        viewer.update(temp);
                    }
                    break;
                } else if (checkLogic == 1) {
                    temp += value;
                    viewer.update(temp);
                    checkLogic = 0;
                    break;
                }
            case ("("):
                if (checkLogic == 0) {
                    checkBrackets++;
                    checkLogic = 0;
                    temp += value;
                    viewer.update(temp);
                    viewer.setErrorCheck("");
                } else {
                    viewer.setErrorCheck("Pleas enter other button");
                }
                break;

            case (")"):
                if (checkBrackets > 0) {
                    checkBrackets--;
                    temp += value;
                    viewer.update(temp);
                    viewer.setErrorCheck("");
                } else {
                    viewer.setErrorCheck("error");
                }
                break;

            default:
                temp += value;
                viewer.update(temp);
                checkLogic = 1;
                viewer.setErrorCheck("");
                break;
        }
    }

}

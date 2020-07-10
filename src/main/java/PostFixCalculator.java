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
 * This class contains a single "reverseString" method that converts text to reverse Polish notation
 */
public class PostFixCalculator {
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";


    /**
     * The method accepts a Postfix expression.
     * Performs all operations using reverse Polish notation.
     * Returns a ready response.
     *
     * @param expression
     *
     * @return double
     */
    public double calculate(String expression) {
        SinglyLinkedListStack<Double> stack = new SinglyLinkedListStack<>();

        String[] inputs = expression.split(" ");

        return handleCalculation(stack, inputs);
    }


    /**
     * The method follows the basic logic of reverse Polish notation.
     * It takes a stack and a Postfix expression as arguments.
     * Returns a ready response.
     *
     * @param postfixExpression
     * @param stack
     *
     * @return double
     */
    private static double handleCalculation(SinglyLinkedListStack<Double> stack, String[] postfixExpression) {
        double operand1, operand2;

        for (int i = 0; i < postfixExpression.length; i++) {
            if (postfixExpression[i].equals(ADD) || postfixExpression[i].equals(SUB)
                    || postfixExpression[i].equals(MUL) || postfixExpression[i].equals(DIV)) {
                operand2 = stack.pop();
                operand1 = stack.pop();
                switch (postfixExpression[i]) {
                    case ADD: {
                        double local = operand1 + operand2;
                        stack.push(local);
                        break;
                    }

                    case SUB: {
                        double local = operand1 - operand2;
                        stack.push(local);
                        break;
                    }

                    case MUL: {
                        double local = operand1 * operand2;
                        stack.push(local);
                        break;
                    }

                    case DIV: {
                        double local = operand1 / operand2;
                        stack.push(local);
                        break;
                    }
                }
            } else {
                stack.push(Double.parseDouble(postfixExpression[i]));
            }
        }
        return stack.pop();
    }

}
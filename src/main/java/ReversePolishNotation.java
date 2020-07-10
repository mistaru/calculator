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
 public class ReversePolishNotation {

    public ReversePolishNotation() {
    }

    /**
     * The method takes an expression as arguments and converts this expression to reverse Polish notation
     * @param expression - mathematical expression
     * @return returns a mathematical expression in the String type
     */
    public static String reverseString(String expression) {
        if (expression == null)
            return null;
        char[] in = expression.toCharArray();
        CharStack stack = new CharStack();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < in.length; i++)
            switch (in[i]) {
                case '+':
                case '-':
                    while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        out.append(' ');
                        out.append(stack.pop());
                    }
                    out.append(' ');
                    stack.push(in[i]);
                    break;
                case '*':
                case '/':
                    out.append(' ');
                    stack.push(in[i]);
                    break;
                case '(':
                    stack.push(in[i]);
                    break;
                case ')':
                    while (!stack.empty() && stack.peek() != '(') {
                        out.append(' ');
                        out.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    out.append(in[i]);
                    break;
            }

        while (!stack.empty())
            out.append(' ').append(stack.pop());

        return out.toString();
    }
}
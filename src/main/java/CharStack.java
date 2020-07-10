/**
 * Automating the calculation of expressions in reverse Polish notation is based on the use of a stack.
 * The CharStack Class acts as a stack in the ReversePolishNotation Class. *
 */
public class CharStack {

    private char[] stack;
    private int size;
    private static final int INITIAL_SIZE = 10;

    public CharStack() {
        stack = new char[INITIAL_SIZE];
        size = 0;
    }

    public void push(char value) {
        if (size == stack.length) {
            doubleCapacity();
        }
        stack[size] = value;
        size++;
    }

    public char pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        char result = stack[size - 1];
        stack[size - 1] = 0;
        size--;
        return result;
    }

    public char peek() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stack[size - 1];
    }

    public boolean empty() {
        return (size == 0);
    }

    private void doubleCapacity() {
        int newCapacity = 2 * stack.length;
        char[] newStack = new char[newCapacity];

        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
}
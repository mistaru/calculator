/**
 * Automating the calculation of expressions in reverse Polish notation is based on the use of a stack.
 * The SinglyLinkedListStack Class acts as a stack in the PostFixCalculator Class. *
 * @param <T>
 */
public class SinglyLinkedListStack<T> {

    private int size;
    private Node<T> head;

    public SinglyLinkedListStack() {
        head = null;
        size = 0;
    }

    public void push(T element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node<T> newNode = new Node(element);
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public T pop() {
        if (head == null)
            return null;
        else {
            T topData = head.data;

            head = head.next;
            size--;

            return topData;
        }
    }

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

    }

}
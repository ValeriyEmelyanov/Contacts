package contacts.utils;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private final List<T> stack;
    private int top;

    public Stack() {
        this.stack = new ArrayList<>();
        this.top = -1;
    }

    public void push(T element) {
        stack.add(element);
        top++;
    }

    public T pop() {
        return stack.remove(top--);
    }

    public T peek() {
        return stack.get(top);
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

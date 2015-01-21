package Stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by manshu on 1/8/15.
 */
public class MinStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= getMin()) stack2.push(x);
    }

    public void pop() {
        int x = stack1.pop();
        if (x == getMin()) stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

    public void display() {
        System.out.println();
        Iterator<Integer> iterator = stack1.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + ", ");
        System.out.println();
        Iterator<Integer> iterator2 = stack2.iterator();
        while (iterator2.hasNext()) System.out.print(iterator2.next() + ", ");
        System.out.println();
    }

    public static void main(String args[]) {
        MinStack ms = new MinStack();
        ms.push(2);
        ms.push(6);
        ms.push(4);
        ms.push(1);
        ms.push(5);
        ms.display();

    }
}

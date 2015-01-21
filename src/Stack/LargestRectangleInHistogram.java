package Stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by manshu on 1/15/15.
 */
public class LargestRectangleInHistogram {
    private static void printStack(Stack<StackItem> stack) {
        Iterator<StackItem> iterator = stack.iterator();
        while(iterator.hasNext()){
            StackItem stackitem = iterator.next();
            System.out.print(stackitem.val + "|" + stackitem.counter + ", ");
        }
        System.out.println();
    }
    private static class StackItem {
        int val;
        int counter;
        StackItem(int val, int counter) {
            this.val = val;
            this.counter = counter;
        }
    }
    public static int largestRectangleArea(int[] height) {
        Stack<StackItem> stack = new Stack<StackItem>();
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.empty()) {
                stack.push(new StackItem(height[i], 1));
                continue;
            }
            if (height[i] > stack.peek().val) stack.push(new StackItem(height[i], 1));
            else if (height[i] == stack.peek().val) {
                //int temp = stack.peek().counter;
                stack.peek().counter += 1;
                //stack.push(new StackItem(height[i], temp));
            }
            else {
                int counter = 0;
                int newArea;
                while (!stack.isEmpty() && height[i] < stack.peek().val) {
                    counter += stack.peek().counter;
                    newArea = counter * stack.pop().val;
                    if (newArea > maxArea) maxArea = newArea;
                }
                if (stack.empty()) {stack.push(new StackItem(height[i], counter + 1));}
                //if (!stack.empty()) stack.peek().counter += counter;
                else {
                    if (height[i] == stack.peek().val) {
                        //int temp = stack.peek().counter;
                        stack.peek().counter += counter + 1;
                        //stack.push(new StackItem(height[i], temp));
                    }
                    if (height[i] > stack.peek().val) stack.push(new StackItem(height[i], counter + 1));
                }
            }
            printStack(stack);
        }
        if (stack.empty()) return maxArea;
        int counter = 0;
        int newArea;
        while (!stack.isEmpty()) {
            counter += stack.peek().counter;
            newArea = counter * stack.pop().val;
            if (newArea > maxArea) maxArea = newArea;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3, 1, 1, 1, 1, 1, 1};
        int arr3[] = {4,2,0,3,2,5};
        int arr2[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(arr2.length);
        System.out.println(largestRectangleArea(arr2));
    }
}

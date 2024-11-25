package lab5;

import java.util.*;

public class QueueExtensions {
    public static <T> Queue<T> reverse(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }
}

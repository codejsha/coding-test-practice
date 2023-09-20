package problem42628;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DoubleEndedPriorityQueue_PriorityQueue {
    public static void main(String[] args) {
        var sol = new DoubleEndedPriorityQueue_PriorityQueue();
        var operations1 = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        var expected1 = new int[]{0, 0};
        var result1 = sol.solution(operations1);
        System.out.println("test1: extend " + Arrays.toString(expected1) + ", result " + Arrays.toString(result1));
        var operations2 = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        var expected2 = new int[]{333, -45};
        var result2 = sol.solution(operations2);
        System.out.println("test2: extend " + Arrays.toString(expected2) + ", result " + Arrays.toString(result2));
    }

    public int[] solution(String[] operations) {
        var minQueue = new PriorityQueue<Integer>();
        var maxQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (var operation : operations) {
            var op = operation.split(" ");
            var opType = op[0];
            var number = Integer.parseInt(op[1]);

            if (opType.equals("D")) {
                if (!maxQueue.isEmpty() && number == 1) {
                    minQueue.remove(maxQueue.poll());
                } else if (!minQueue.isEmpty() && number == -1) {
                    maxQueue.remove(minQueue.poll());
                }
            } else if (opType.equals("I")) {
                minQueue.add(number);
                maxQueue.add(number);
            }
        }

        if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            return new int[]{maxQueue.peek(), minQueue.peek()};
        }
        return new int[]{0, 0};
    }
}

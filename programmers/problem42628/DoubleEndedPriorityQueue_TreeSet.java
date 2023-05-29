package problem42628;

import java.util.Arrays;
import java.util.TreeSet;

public class DoubleEndedPriorityQueue_TreeSet {
    public static void main(String[] args) {
        var sol = new DoubleEndedPriorityQueue_TreeSet();
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
        var set = new TreeSet<Integer>();

        for (var operation : operations) {
            var op = operation.split(" ");
            var opType = op[0];
            var number = Integer.parseInt(op[1]);

            if (opType.equals("D") && !set.isEmpty()) {
                if (number == 1) {
                    set.remove(set.last());     // max
                } else if (number == -1) {
                    set.remove(set.first());    // min
                }
            } else if (opType.equals("I")) {
                set.add(number);
            }
        }

        if (!set.isEmpty()) {
            return new int[]{set.last(), set.first()};
        }
        return new int[]{0, 0};
    }
}

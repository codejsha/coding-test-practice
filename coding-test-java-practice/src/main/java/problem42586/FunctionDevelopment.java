package problem42586;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class FunctionDevelopment {
    public static void main(String[] args) {
        var sol = new FunctionDevelopment();
        var progresses1 = new int[]{93, 30, 55};
        var speeds1 = new int[]{1, 30, 5};
        var expected1 = new int[]{2, 1};
        var result1 = sol.solution(progresses1, speeds1);
        System.out.println("test1: expected:" + Arrays.toString(expected1)
                + " result:" + Arrays.toString(result1));
        var progresses2 = new int[]{95, 90, 99, 99, 80, 99};
        var speeds2 = new int[]{1, 1, 1, 1, 1, 1};
        var expected2 = new int[]{1, 3, 2};
        var result2 = sol.solution(progresses2, speeds2);
        System.out.println("test2: expected:" + Arrays.toString(expected2)
                + " result:" + Arrays.toString(result2));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        var queue = new ArrayDeque<Integer>(progresses.length);
        for (var i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        var list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            var current = queue.poll();
            var complete = 1;
            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.poll();
                complete++;
            }
            list.add(complete);
        }

        var result = new int[list.size()];
        for (var i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

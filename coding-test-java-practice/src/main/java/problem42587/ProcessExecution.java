package problem42587;

import java.util.Collections;
import java.util.PriorityQueue;

public class ProcessExecution {
    public static void main(String[] args) {
        var sol = new ProcessExecution();
        var priorities1 = new int[]{2, 1, 3, 2};
        var location1 = 2;
        var expected1 = 1;
        var result1 = sol.solution(priorities1, location1);
        System.out.println("test1: expected:" + expected1 + " result:" + result1);
        var priorities2 = new int[]{1, 1, 9, 1, 1, 1};
        var location2 = 0;
        var expected2 = 5;
        var result2 = sol.solution(priorities2, location2);
        System.out.println("test2: expected:" + expected2 + " result:" + result2);
    }

    public int solution(int[] priorities, int location) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (var priority : priorities) {
            pq.add(priority);
        }

        var order = 0;
        while (!pq.isEmpty()) {
            for (var i = 0; i < priorities.length; i++) {
                if (!pq.isEmpty() && priorities[i] == pq.peek()) {
                    order++;
                    if (i == location) {
                        return order;
                    }
                    pq.poll();
                }
            }
        }

        return -1;
    }
}

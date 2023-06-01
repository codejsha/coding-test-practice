package problem12927;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OvertimeIndex {
    public static void main(String[] args) {
        var sol = new OvertimeIndex();
        var works1 = new int[]{4, 3, 3};
        var n1 = 4;
        var expected1 = 12;
        var result1 = sol.solution(n1, works1);
        System.out.println("test1: expected: " + expected1 + ", result: " + result1);
        var works2 = new int[]{2, 1, 2};
        var n2 = 1;
        var expected2 = 6;
        var result2 = sol.solution(n2, works2);
        System.out.println("test2: expected: " + expected2 + ", result: " + result2);
        var works3 = new int[]{1, 1};
        var n3 = 3;
        var expected3 = 0;
        var result3 = sol.solution(n3, works3);
        System.out.println("test3: expected: " + expected3 + ", result: " + result3);
    }

    public long solution(int n, int[] works) {
        var queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (var e : works) {
            queue.offer(e);
        }

        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty()) {
                var work = queue.poll();
                if (work == 0) {
                    break;
                }
                queue.offer(work - 1);
            }
        }

        long answer = 0;
        for (var work : queue) {
            answer += (long) work * work;
        }
        return answer;
    }
}

package problem42626;

import java.util.PriorityQueue;

public class Spicier {
    public static void main(String[] args) {
        var sol = new Spicier();
        var scoville1 = new int[]{1, 2, 3, 9, 10, 12};
        var K1 = 7;
        var expected1 = 2;
        var result1 = sol.solution(scoville1, K1);
        System.out.println("expected: " + expected1 + ", result: " + result1);
    }

    public int solution(int[] scoville, int K) {
        var queue = new PriorityQueue<Integer>();
        for (var i : scoville) {
            queue.add(i);
        }

        var mixCount = 0;
        while (queue.size() >= 2 && queue.peek() < K) {
            var first = queue.poll();
            assert queue.peek() != null;
            var second = queue.poll();
            queue.add(first + second * 2);
            mixCount++;
        }

        if (queue.size() == 0 || queue.peek() < K) {
            return -1;
        }

        return mixCount;
    }
}

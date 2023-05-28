package problem87390;

import java.util.Arrays;

public class NSquaredArray {
    public static void main(String[] args) {
        var sol = new NSquaredArray();
        var n1 = 3;
        var left1 = 2;
        var right1 = 5;
        var result1 = sol.solution(n1, left1, right1);
        System.out.println("test1: expected: [3, 2, 2, 3] result: " + Arrays.toString(result1));
        var n2 = 4;
        var left2 = 7;
        var right2 = 14;
        var result2 = sol.solution(n2, left2, right2);
        System.out.println("test2: expected: [4, 3, 3, 3, 4, 4, 4, 4] result: " + Arrays.toString(result2));
    }

    public int[] solution(int n, long left, long right) {
        var length = (int) (right - left + 1);
        var result = new int[length];

        var index = 0;
        for (var i = left; i <= right; i++) {
            var quotient = (int) (i / n);
            var remainder = (int) (i % n);
            result[index] = Math.max(quotient, remainder) + 1;
            index++;
        }

        return result;
    }
}

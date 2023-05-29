package problem12938;

import java.util.Arrays;

public class BestSet {
    public static void main(String[] args) {
        var sol = new BestSet();
        var n1 = 2;
        var s1 = 9;
        var expected1 = new int[]{4, 5};
        var result = sol.solution(n1, s1);
        System.out.println("test1: expected: " + Arrays.toString(expected1) + ", result: " + Arrays.toString(result));
        var n2 = 2;
        var s2 = 1;
        var expected2 = new int[]{-1};
        result = sol.solution(n2, s2);
        System.out.println("test2: expected: " + Arrays.toString(expected2) + ", result: " + Arrays.toString(result));
        var n3 = 2;
        var s3 = 8;
        var expected3 = new int[]{4, 4};
        result = sol.solution(n3, s3);
        System.out.println("test3: expected: " + Arrays.toString(expected3) + ", result: " + Arrays.toString(result));
    }

    public int[] solution(int n, int s) {
        var quotient = s / n;
        var remainder = s % n;

        if (quotient == 0) {
            return new int[]{-1};
        }

        var arr = new int[n];
        for (var i = n - 1; i >= 0; i--) {
            arr[i] = quotient;
            if (remainder != 0) {
                arr[i] += 1;
                remainder--;
            }
        }
        return arr;
    }
}

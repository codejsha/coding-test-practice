package problem12941;

import java.util.Arrays;

public class MinimumValue {
    public static void main(String[] args) {
        var A = new int[]{1, 4, 2};
        var B = new int[]{5, 4, 4};
        var sol = new MinimumValue();
        System.out.println(sol.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        var answer = 0;
        var length = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for (var i = 0; i < length; i++) {
            answer += A[i] * B[length - 1 - i];
        }

        return answer;
    }
}

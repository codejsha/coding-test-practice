package problem12941;

import java.util.Arrays;

public class MinimumValue {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        var sol = new MinimumValue();
        System.out.println(sol.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int length = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < length; i++) {
            answer += A[i] * B[length - 1 - i];
        }

        return answer;
    }
}

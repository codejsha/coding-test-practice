package problem131701;

import java.util.HashSet;

public class ConsecutiveSubsequenceSum_Loop {
    public static void main(String[] args) {
        var sol = new ConsecutiveSubsequenceSum_DP();
        var elements = new int[]{7, 9, 1, 1, 4};
        var expected = 18;
        var result = sol.solution(elements);
        System.out.println("test: expected:" + expected + " result:" + result);
    }

    public int solution(int[] elements) {
        var set = new HashSet<Integer>();

        for (var i = 1; i <= elements.length; i++) {
            for (var j = 0; j < elements.length; j++) {
                var sum = 0;
                for (var k = 0; k < i; k++) {
                    if (j + k < elements.length) {
                        sum += elements[j + k];
                    } else {
                        sum += elements[(j + k) % elements.length];
                    }
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}

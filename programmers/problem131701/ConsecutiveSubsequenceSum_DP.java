package problem131701;

import java.util.HashSet;

public class ConsecutiveSubsequenceSum_DP {
    public static void main(String[] args) {
        var sol = new ConsecutiveSubsequenceSum_DP();
        var elements = new int[]{7, 9, 1, 1, 4};
        var expected = 18;
        var result = sol.solution(elements);
        System.out.println("test: expected:" + expected + " result:" + result);
    }

    public int solution(int[] elements) {
        var sums = new HashSet<>();
        var seqLength = elements.length;

        // Calculate prefix sums
        var prefixSums = new int[2 * seqLength + 1];
        for (var i = 1; i <= 2 * seqLength; i++) {
            prefixSums[i] = prefixSums[i - 1] + elements[(i - 1) % seqLength];
        }

        // Iterate over the array for start index
        for (var start = 0; start < seqLength; start++) {
            // Iterate for all possible lengths of subsequences
            for (var length = 1; length <= seqLength; length++) {
                var end = start + length;

                // Calculate sum using prefix sums
                var sum = prefixSums[end] - prefixSums[start];

                sums.add(sum);  // Add current sum to set
            }
        }

        return sums.size();
    }
}

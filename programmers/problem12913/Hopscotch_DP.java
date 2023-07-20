package problem12913;

import java.util.Arrays;

/**
 * DP solution
 */
public class Hopscotch_DP {
    public static void main(String[] args) {
        final var sol = new Hopscotch_DP();
        final var land = new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        final var expected = 16;
        final var result = sol.solution(land);
        System.out.println("expected: " + expected + " result: " + result);
    }

    public int solution(int[][] land) {
        final var dp = new int[land.length][land[0].length];
        // copy first row
        System.arraycopy(land[0], 0, dp[0], 0, land[0].length);

        // i = row, j and k = col
        for (var i = 1; i < land.length; i++) {
            for (var j = 0; j < land[i].length; j++) {
                for (var k = 0; k < land[i].length; k++) {
                    if (j != k) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                    }
                }
            }
        }

        var max = 0;
        for (var i = 0; i < land[0].length; i++) {
            max = Math.max(max, dp[land.length - 1][i]);
        }
        return max;
    }
}

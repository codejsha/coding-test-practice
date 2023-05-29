package problem12949;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        var sol = new MatrixMultiplication();
        var arr1_1 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
        var arr1_2 = new int[][]{{3, 3}, {3, 3}};
        var expected1 = new int[][]{{15, 15}, {15, 15}, {15, 15}};
        var result1 = sol.solution(arr1_1, arr1_2);
        System.out.println("test: expected:" + Arrays.deepToString(expected1)
                + " result:" + Arrays.deepToString(result1));
        var arr2_1 = new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        var arr2_2 = new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        var expected2 = new int[][]{{22, 22, 11}, {36, 28, 18}, {29, 20, 14}};
        var result2 = sol.solution(arr2_1, arr2_2);
        System.out.println("test: expected:" + Arrays.deepToString(expected2)
                + " result:" + Arrays.deepToString(result2));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        var m = arr1.length;
        var n = arr2[0].length;
        var result = new int[m][n];

        var p = arr2.length;
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                for (var k = 0; k < p; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}

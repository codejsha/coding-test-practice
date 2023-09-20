package problem12913;

/**
 * DFS solution
 * this solution is not accepted because of time limit exceeded
 */
public class Hopscotch_DFS {
    public static void main(String[] args) {
        final var sol = new Hopscotch_DFS();
        final var land = new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        final var expected = 16;
        final var result = sol.solution(land);
        System.out.println("expected: " + expected + " result: " + result);
    }

    public int solution(int[][] land) {
        var max = 0;
        for (var i = 0; i < land[0].length; i++) {
            max = Math.max(max, dfs(land, 0, i, 0));
        }
        return max;
    }

    private int dfs(int[][] land, int row, int col, int sum) {
        if (row == land.length) {
            return sum;
        }
        var max = 0;
        for (var i = 0; i < land[row].length; i++) {
            if (i != col) {
                max = Math.max(max, dfs(land, row + 1, i, sum + land[row][i]));
            }
        }
        return max;
    }
}

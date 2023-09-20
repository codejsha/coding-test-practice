package problem42898;

public class RoadToSchool {
    public static void main(String[] args) {
        var sol = new RoadToSchool();
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        var expected = 4;
        var result = sol.solution(m, n, puddles);
        System.out.println("expected: " + expected + ", result: " + result);
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] road = new int[n][m];
        for (int[] puddle : puddles) {
            road[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        road[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (road[i][j] == -1) {
                    road[i][j] = 0;
                    continue;
                }

                if (i >= 1) {
                    road[i][j] += road[i - 1][j];
                }
                if (j >= 1) {
                    road[i][j] += road[i][j - 1];
                }
                road[i][j] %= 1000000007;
            }
        }

        return road[n - 1][m - 1];
    }
}

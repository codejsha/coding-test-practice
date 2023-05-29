package problem87946;

public class Fatigue_DFS {
    public static void main(String[] args) {
        var sol = new Fatigue_DFS();
        var k = 80;
        var dungeons = new int[][]{{80, 20}, {50, 40}, {30, 10}};
        var expected = 3;
        var result = sol.solution(k, dungeons);
        System.out.println("test: expected: " + expected + " result: " + result);
    }

    public int solution(int k, int[][] dungeons) {
        var visited = new boolean[dungeons.length];
        return dfs(k, dungeons, visited, 0);
    }

    public int dfs(int fatigue, int[][] dungeons, boolean[] visited, int depth) {
        var maxDepth = depth;

        for (var i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                var newDepth = dfs(fatigue - dungeons[i][1], dungeons, visited, depth + 1);
                maxDepth = Math.max(maxDepth, newDepth);
                visited[i] = false;
            }
        }

        return maxDepth;
    }
}

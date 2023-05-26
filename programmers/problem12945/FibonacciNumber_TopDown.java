package problem12945;

public class FibonacciNumber_TopDown {
    public static void main(String[] args) {
        int n = 5;
        var sol = new FibonacciNumber_BottomUp();
        System.out.println(sol.solution(n));
    }

    public int topDown(int n, int[] memo) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (memo[n] > 0) return memo[n];

        memo[n] = (topDown(n - 1, memo) + topDown(n - 2, memo)) % 1234567;

        return memo[n];
    }

    public int solution(int n) {
        var memo = new int[n + 1];
        return topDown(n, memo);
    }
}

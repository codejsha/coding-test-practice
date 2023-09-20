package problem12945;

public class FibonacciNumber_BottomUp {
    public static void main(String[] args) {
        var n = 5;
        var sol = new FibonacciNumber_BottomUp();
        System.out.println(sol.solution(n));
    }

    public int solution(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        var memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (var i = 2; i < n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
        }
        return (memo[n - 1] + memo[n - 2]) % 1234567;
    }
}

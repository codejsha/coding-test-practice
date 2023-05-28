package problem12924;

public class NumberExpression {
    public static void main(String[] args) {
        var n = 15;
        var sol = new NumberExpression();
        System.out.println(sol.solution(n));
    }

    public int solution(int n) {
        var answer = 0;
        var start = 1;
        var sum = 0;
        var last = start;
        var added = false;

        while (start <= n) {
            sum += start++;

            if (sum == n) {
                answer++;
                sum = 0;
                start = last + 1;
                added = true;
            } else if (sum > n) {
                sum = 0;
                start = last + 1;
                last++;
            }

            if (added) {
                last++;
                added = false;
            }
        }

        return answer;
    }
}

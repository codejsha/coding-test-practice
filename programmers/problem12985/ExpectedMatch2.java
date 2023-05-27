package problem12985;

public class ExpectedMatch2 {
    public static void main(String[] args) {
        var sol = new ExpectedMatch1();
        var n = 8;
        var a = 4;
        var b = 7;
        System.out.println(sol.solution(n, a, b));
    }

    public int solution(int n, int a, int b) {
        int round = 0;
        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            round++;
        }
        return round;
    }
}

package problem12985;

public class ExpectedMatch1 {
    public static void main(String[] args) {
        var sol = new ExpectedMatch1();
        var n = 8;
        var a = 4;
        var b = 7;
        System.out.println(sol.solution(n, a, b));
    }

    public int solution(int n, int a, int b) {
        var round = 1;

        for (var i = 0; i < n / 2; i++) {
            if (a % 2 == 0 && b % 2 == 1 && b + 1 == a) {
                break;
            }
            if (b % 2 == 0 && a % 2 == 1 && a + 1 == b) {
                break;
            }

            a = (int) Math.ceil(a / 2.0);
            b = (int) Math.ceil(b / 2.0);
            round++;
        }
        return round;
    }
}

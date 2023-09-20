package problem12980;

public class JumpAndTeleport {
    public static void main(String[] args) {
        var sol = new JumpAndTeleport();
        var n1 = 5;
        System.out.println(sol.solution(n1));
    }

    public int solution(int n) {
        var power = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                power++;
            }
        }
        return power;
    }
}

package problem12914;

public class LongJump {
    public static void main(String[] args) {
        var sol = new LongJump();
        var n1 = 4;
        System.out.println(sol.solution(4));
        var n2 = 3;
        System.out.println(sol.solution(3));
    }

    public long solution(int n) {
        var seq = new int[2001];
        seq[1] = 1;
        seq[2] = 2;
        for (var i = 3; i < seq.length; i++) {
            seq[i] = (seq[i - 2] + seq[i - 1]) % 1234567;
        }
        return seq[n];
    }
}

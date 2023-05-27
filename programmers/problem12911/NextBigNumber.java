package problem12911;

public class NextBigNumber {
    public static void main(String[] args) {
        int n = 78;
        var sol = new NextBigNumber();
        System.out.println(sol.solution(n));
        System.out.println(Integer.toBinaryString(sol.solution(n)));
    }

    public int solution(int n) {
        var bits = Integer.bitCount(n);
        do {
            n++;
        } while (bits != Integer.bitCount(n));
        return n;
    }
}

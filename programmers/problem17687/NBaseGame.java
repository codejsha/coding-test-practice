package problem17687;

public class NBaseGame {
    public static void main(String[] args) {
        var sol = new NBaseGame();
        var n1 = 16;
        var t1 = 16;
        var m1 = 2;
        var p1 = 1;
        var expected1 = "0111";
        var result1 = sol.solution(n1, t1, m1, p1);
        System.out.println("expected: " + expected1 + ", result: " + result1);
    }

    /**
     * find n-th output of p
     *
     * @param n base
     * @param t number
     * @param m players
     * @param p tube (target player)
     * @return output
     */
    public String solution(int n, int t, int m, int p) {
        var sb = new StringBuilder();

        int index = 0;
        while (sb.length() < m * t) {
            sb.append(Integer.toString(index, n).toUpperCase());
            index++;
        }

        var answer = new StringBuilder();
        int pIndex = p - 1;
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt(pIndex));
            pIndex += m;
        }

        return answer.toString();
    }
}

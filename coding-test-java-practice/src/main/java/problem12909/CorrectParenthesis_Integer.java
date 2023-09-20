package problem12909;

/**
 * Total score: 100.0 / 100.0
 */
public class CorrectParenthesis_Integer {
    public static void main(String[] args) {
        var s = "()()";
        var sol = new CorrectParenthesis_Integer();
        System.out.println(sol.solution(s));
    }

    boolean solution(String s) {
        if (s.startsWith(")") || s.endsWith("(") || s.length() % 2 != 0) {
            return false;
        }

        var counter = 0;
        for (var letter : s.toCharArray()) {
            if (letter == '(') {
                counter++;
            } else {
                if (counter == 0) {
                    return false;
                }
                counter--;
            }
        }

        return counter == 0;
    }
}

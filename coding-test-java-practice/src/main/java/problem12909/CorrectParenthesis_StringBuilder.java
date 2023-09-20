package problem12909;

import java.util.Stack;

/**
 * Total score: 84.8 / 100.0
 */
public class CorrectParenthesis_StringBuilder {
    public static void main(String[] args) {
        var s = "()()";
        var sol = new CorrectParenthesis_StringBuilder();
        System.out.println(sol.solution(s));
    }

    boolean solution(String s) {
        if (s.startsWith(")") || s.endsWith("(") || s.length() % 2 != 0) {
            return false;
        }

        var stack = new Stack<String>();
        var sb = new StringBuilder(s);

        for (var i = 0; i < sb.length(); i++) {
            var letter = sb.substring(i, i + 1);
            if (letter.equals("(")) {
                stack.push(letter);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

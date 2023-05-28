package problem12909;

import java.util.Stack;

/**
 * Total score: 100.0 / 100.0
 */
public class CorrectParenthesis_Char {
    public static void main(String[] args) {
        var s = "()()";
        var sol = new CorrectParenthesis_Char();
        System.out.println(sol.solution(s));
    }

    boolean solution(String s) {
        if (s.startsWith(")") || s.endsWith("(") || s.length() % 2 != 0) {
            return false;
        }

        var stack = new Stack<Character>();
        for (var letter : s.toCharArray()) {
            if (letter == '(') {
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

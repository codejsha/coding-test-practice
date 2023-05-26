package problem12909;

import java.util.Stack;

/**
 * Total score: 84.8 / 100.0
 */
public class CorrectParenthesis_Substring {
    public static void main(String[] args) {
        String s = "()()";
        var sol = new CorrectParenthesis_Substring();
        System.out.println(sol.solution(s));
    }

    boolean solution(String s) {
        var stack = new Stack<String>();

        for (var i = 0; i < s.length(); i++) {
            var letter = s.substring(i, i + 1);
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

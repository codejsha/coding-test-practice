package problem12909;

import java.util.Stack;

/**
 * Total score: 69.5 / 100.0
 */
public class CorrectParenthesis_Split {
    public static void main(String[] args) {
        var s = "()()";
        var sol = new CorrectParenthesis_Split();
        System.out.println(sol.solution(s));
    }

    boolean solution(String s) {
        var stack = new Stack<String>();
        var letters = s.split("");

        if (letters.length % 2 != 0) {
            return false;
        }

        for (var letter : letters) {
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

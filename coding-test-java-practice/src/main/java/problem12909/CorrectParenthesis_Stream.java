package problem12909;

import java.util.Arrays;
import java.util.Stack;

/**
 * Total score: 61.8 / 100.0
 */
public class CorrectParenthesis_Stream {
    public static void main(String[] args) {
        var s = "()()";
        var sol = new CorrectParenthesis_Stream();
        System.out.println(sol.solution(s));
    }

    boolean solution(String s) {
        var stack = new Stack<String>();

        Arrays.stream(s.split("")).forEach(letter -> {
            if (letter.equals("(")) {
                stack.push(letter);
            } else {
                if (stack.isEmpty()) {
                    return;
                }
                stack.pop();
            }
        });

        return stack.isEmpty();
    }
}

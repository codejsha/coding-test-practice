package problem12973;

import java.util.Stack;

/**
 * Total score: 100.0 / 100.0
 */
public class GroupElimination_Stack1 {
    public static void main(String[] args) {
        var sol = new GroupElimination_Stack1();
        String s1 = "baabaa";
        System.out.println(sol.solution(s1));
        String s2 = "cdcd";
        System.out.println(sol.solution(s2));
    }

    public int solution(String s) {
        var arr = s.toCharArray();

        var stack = new Stack<Character>();
        for (var value : arr) {
            if (!stack.isEmpty() && stack.peek().equals(value)) {
                stack.pop();
            } else {
                stack.push(value);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}

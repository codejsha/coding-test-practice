package problem12973;

import java.util.Stack;

/**
 * Total score: 95.0 / 100.0
 */
public class GroupElimination_Stack2 {
    public static void main(String[] args) {
        var sol = new GroupElimination_Stack2();
        String s1 = "baabaa";
        System.out.println(sol.solution(s1));
        String s2 = "cdcd";
        System.out.println(sol.solution(s2));
    }

    public int solution(String s) {
        var arr = s.split("");

        var stack = new Stack<String>();
        for (var value : arr) {
            if (stack.isEmpty() || !stack.peek().equals(value)) {
                stack.push(value);
            } else if (stack.peek().equals(value)) {
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}

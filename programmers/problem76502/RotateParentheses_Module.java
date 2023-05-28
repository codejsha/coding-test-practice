package problem76502;

import java.util.Stack;

public class RotateParentheses_Module {
    public static void main(String[] args) {
        var sol = new RotateParentheses_Module();
        var s1 = "[](){}";
        var expected1 = 3;
        var result1 = sol.solution(s1);
        System.out.println("test1: expected:" + expected1 + " result:" + result1);
        var s2 = "}]()[{";
        var expected2 = 2;
        var result2 = sol.solution(s2);
        System.out.println("test2: expected:" + expected2 + " result:" + result2);
        var s3 = "[)(]";
        var expected3 = 0;
        var result3 = sol.solution(s3);
        System.out.println("test3: expected:" + expected3 + " result:" + result3);
        var s4 = "}}}";
        var expected4 = 0;
        var result4 = sol.solution(s4);
        System.out.println("test4: expected:" + expected4 + " result:" + result4);
    }

    public int solution(String s) {
        var count = 0;

        for (int i = 0; i < s.length(); i++) {
            var temp = s.substring(i) + s.substring(0, i);

            if (isCorrectParentheses(temp)) {
                count++;
            }
        }

        return count;
    }

    private boolean isCorrectParentheses(String temp) {
        var stack = new Stack<Character>();

        for (var ch : temp.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);

            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                var current = stack.peek();
                stack.pop();

                if (ch == ')' && current != '(') {
                    return false;
                } else if (ch == ']' && current != '[') {
                    return false;
                } else if (ch == '}' && current != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

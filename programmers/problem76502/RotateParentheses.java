package problem76502;

import java.util.Stack;

public class RotateParentheses {
    public static void main(String[] args) {
        var sol = new RotateParentheses();
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
        var stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            var temp = s.substring(i) + s.substring(0, i);

            stack.clear();
            var isCorrect = true;
            for (var ch : temp.toCharArray()) {
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);

                } else {
                    if (stack.isEmpty()) {
                        isCorrect = false;
                        break;
                    }

                    var current = stack.peek();
                    stack.pop();
                    if (ch == ')' && current != '(') {
                        isCorrect = false;
                        break;
                    } else if (ch == ']' && current != '[') {
                        isCorrect = false;
                        break;
                    } else if (ch == '}' && current != '{') {
                        isCorrect = false;
                        break;
                    }
                }

            }

            if (stack.isEmpty() && isCorrect) count++;
        }

        return count;
    }
}

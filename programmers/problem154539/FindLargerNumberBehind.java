package problem154539;

import java.util.Arrays;
import java.util.Stack;

public class FindLargerNumberBehind {
    public static void main(final String[] args) {
        final var sol = new FindLargerNumberBehind();
        final var numbers = new int[]{9, 1, 5, 3, 6, 2};
        final var expected = new int[]{-1, 5, 6, 6, -1, -1};
        final var result = sol.solution(numbers);
        System.out.println("expected: " + Arrays.toString(expected) + " result: " + Arrays.toString(result));
    }

    public int[] solution(final int[] numbers) {
        final var result = new int[numbers.length];
        Arrays.fill(result, -1);
        final var stack = new Stack<Integer>();

        for (var i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        return result;
    }
}

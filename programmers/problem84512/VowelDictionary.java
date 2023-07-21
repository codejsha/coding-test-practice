package problem84512;

public class VowelDictionary {
    public static void main(String[] args) {
        final var sol = new VowelDictionary();
        final var word = "AAAAE";
        final var expected = 6;
        final var result = sol.solution(word);
        System.out.println("expected: " + expected + " result: " + result);
    }

    public int solution(String word) {
        final var vowels = new char[]{'A', 'E', 'I', 'O', 'U'};
        final var increment = new int[]{781, 156, 31, 6, 1};
        var answer = 0;

        for (var i = 0; i < word.length(); i++) {
            for (var j = 0; j < vowels.length; j++) {
                if (word.charAt(i) == vowels[j]) {
                    answer += 1 + increment[i] * j;
                }
            }
        }

        return answer;
    }
}

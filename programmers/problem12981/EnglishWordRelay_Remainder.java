package problem12981;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class EnglishWordRelay_Remainder {
    public static void main(String[] args) {
        var sol = new EnglishWordRelay_Remainder();
        var n1 = 3;
        var words1 = new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(sol.solution(n1, words1)));
        var n2 = 5;
        var words2 = new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
                "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println(Arrays.toString(sol.solution(n2, words2)));
        var n3 = 2;
        var words3 = new String[]{"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(sol.solution(n3, words3)));
    }

    public int[] solution(int n, String[] words) {
        var answer = new int[2];
        var table = new HashSet<String>();
        var players = new ArrayList<Integer>();
        for (var i = 1; i <= n; i++) {
            players.add(i);
        }

        var prevWord = "";
        for (var i = 0; i < words.length; i++) {
            var word = words[i];
            var player = players.get(i % n);    // i % n + 1
            var round = i / n + 1;

            if (table.contains(word) || (!prevWord.isEmpty() && prevWord.charAt(prevWord.length() - 1) != word.charAt(0))) {
                answer[0] = player;
                answer[1] = round;
                return answer;
            }

            table.add(word);
            prevWord = word;
        }

        return answer;
    }
}

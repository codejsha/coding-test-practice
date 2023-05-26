package problem12981;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class EnglishWordRelay_ArrayDeque {
    public static void main(String[] args) {
        var sol = new EnglishWordRelay_ArrayDeque();
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
        int[] answer = new int[2];
        var table = new HashMap<String, Integer>();
        var players = new ArrayDeque<Integer>();
        for (var i = 1; i <= n; i++) {
            players.add(i);
        }

        var count = n;
        var loop = 1;
        var prevWord = "";
        for (var word : words) {
            var player = players.getFirst();
            var collision = table.getOrDefault(word, -1);

            if (collision >= 1 || !prevWord.isEmpty() && prevWord.charAt(prevWord.length() - 1) != word.charAt(0)) {
                answer[0] = player;
                answer[1] = loop;
                break;
            }

            table.put(word, 1);
            players.removeFirst();
            players.addLast(player);

            prevWord = word;
            count--;
            if (count == 0) {
                loop++;
                count = n;
            }
        }
        return answer;
    }
}

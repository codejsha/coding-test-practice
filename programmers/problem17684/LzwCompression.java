package problem17684;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LzwCompression {
    public static void main(String[] args) {
        var sol = new LzwCompression();
        var msg1 = "KAKAO";
        var expected1 = new int[]{11, 1, 27, 15};
        var result1 = sol.solution(msg1);
        System.out.println("expected: " + Arrays.toString(expected1) + ", result: " + Arrays.toString(result1));
    }

    public int[] solution(String msg) {
        var map = new HashMap<String, Integer>();
        var index = 0;
        for (index = 0; index < 26; index++) {
            map.put(String.valueOf((char) ('A' + index)), index + 1);
        }

        var list = new ArrayList<Integer>();
        int i = 0;
        var j = 1;
        var temp = "";
        while (i < msg.length()) {
            var s = msg.substring(i, j);
            if (map.containsKey(s)) {
                temp = s;
                j++;
            } else {
                list.add(map.get(temp));
                map.put(s, ++index);
                i += s.length() - 1;
                j = i + 1;
            }

            if (j > msg.length()) {
                list.add(map.get(temp));
                break;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

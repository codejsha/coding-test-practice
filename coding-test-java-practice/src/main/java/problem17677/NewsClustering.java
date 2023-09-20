package problem17677;

import java.util.HashMap;

public class NewsClustering {
    public static void main(String[] args) {
        var sol = new NewsClustering();
        var str1_1 = "FRANCE";
        var str1_2 = "french";
        var expected1 = 16384;
        var result1 = sol.solution(str1_1, str1_2);
        System.out.println("test1: expected:" + expected1 + " result:" + result1);
        var str2_1 = "handshake";
        var str2_2 = "shake hands";
        var expected2 = 65536;
        var result2 = sol.solution(str2_1, str2_2);
        System.out.println("test2: expected:" + expected2 + " result:" + result2);
        var str3_1 = "aa1+aa2";
        var str3_2 = "AAAA12";
        var expected3 = 43690;
        var result3 = sol.solution(str3_1, str3_2);
        System.out.println("test3: expected:" + expected3 + " result:" + result3);
        var str4_1 = "E=M*C^2";
        var str4_2 = "e=m*c^2";
        var expected4 = 65536;
        var result4 = sol.solution(str4_1, str4_2);
        System.out.println("test4: expected:" + expected4 + " result:" + result4);
    }

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        var map1 = new HashMap<String, Integer>();
        var total = 0;
        var intersection = 0;

        for (var i = 0; i < str1.length() - 1; i++) {
            var element = str1.substring(i, i + 2);
            if (element.matches("[a-z]{2}")) {
                total++;
                map1.put(element, map1.getOrDefault(element, 0) + 1);
            }
        }
        for (var i = 0; i < str2.length() - 1; i++) {
            var element = str2.substring(i, i + 2);
            if (element.matches("[a-z]{2}")) {
                total++;
                if (map1.containsKey(element) && map1.get(element) > 0) {
                    intersection++;
                    map1.put(element, map1.get(element) - 1);
                }
            }
        }

        var union = total - intersection;
        if (union == 0 && intersection == 0) {
            return 65536;
        } else if (union > 0 && intersection == 0) {
            return 0;
        } else {
            return (int) Math.floor((double) intersection / union * 65536);
        }
    }
}

package problem64065;

import java.util.*;

public class ConvertSetArrayToTuple_Set {
    public static void main(String[] args) {
        var sol = new ConvertSetArrayToTuple_Set();
        var s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        var expected1 = new int[]{2, 1, 3, 4};
        var result1 = sol.solution(s1);
        System.out.println("test1: expected:" + Arrays.toString(expected1)
                + " result:" + Arrays.toString(result1));
        var s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        var expected2 = new int[]{2, 1, 3, 4};
        var result2 = sol.solution(s2);
        System.out.println("test2: expected:" + Arrays.toString(expected2)
                + " result:" + Arrays.toString(result2));
        var s3 = "{{20,111},{111}}";
        var expected3 = new int[]{111, 20};
        var result3 = sol.solution(s3);
        System.out.println("test3: expected:" + Arrays.toString(expected3)
                + " result:" + Arrays.toString(result3));
        var s4 = "{{123}}";
        var expected4 = new int[]{123};
        var result4 = sol.solution(s4);
        System.out.println("test4: expected:" + Arrays.toString(expected4)
                + " result:" + Arrays.toString(result4));
        var s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        var expected5 = new int[]{3, 2, 4, 1};
        var result5 = sol.solution(s5);
        System.out.println("test5: expected:" + Arrays.toString(expected5)
                + " result:" + Arrays.toString(result5));
    }

    public int[] solution(String s) {
        var arr = s.replaceFirst("^.{2}", "")
                .replaceFirst(".{2}$", "")
                .split("},\\{");
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        var set = new HashSet<String>();
        var result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (var e : arr[i].split(",")) {
                if (set.add(e)) {
                    result[i] = Integer.parseInt(e);
                }
            }
        }

        return result;
    }
}

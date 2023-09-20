package problem138476;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class PickTangerine {
    public static void main(String[] args) {
        var sol = new PickTangerine();
        var k1 = 6;
        var tangerine1 = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(sol.solution(k1, tangerine1));
        var k2 = 4;
        var tangerine2 = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(sol.solution(k2, tangerine2));
        var k3 = 2;
        var tangerine3 = new int[]{1, 1, 1, 1, 2, 2, 2, 3};
        System.out.println(sol.solution(k3, tangerine3));
    }

    public int solution(int k, int[] tangerine) {
        var map = new HashMap<Integer, Integer>();
        for (var t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        var list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());

        var it = list.iterator();
        var answer = 0;
        while (it.hasNext()) {
            var value = it.next();
            k -= value;
            answer++;

            if (k <= 0) {
                break;
            }
        }
        return answer;
    }
}

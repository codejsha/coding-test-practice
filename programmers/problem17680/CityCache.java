package problem17680;

import java.util.ArrayDeque;

public class CityCache {
    public static void main(String[] args) {
        var sol = new CityCache();
        var cacheSize1 = 3;
        var cities1 = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork",
                "LA"};
        var expected1 = 50;
        var result1 = sol.solution(cacheSize1, cities1);
        System.out.println("expected1: " + expected1 + ", result1: " + result1);
        var cacheSize2 = 3;
        var cities2 = new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        var expected2 = 21;
        var result2 = sol.solution(cacheSize2, cities2);
        System.out.println("expected2: " + expected2 + ", result2: " + result2);
        var cacheSize3 = 2;
        var cities3 = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome",
                "Paris", "Jeju", "NewYork", "Rome"};
        var expected3 = 60;
        var result3 = sol.solution(cacheSize3, cities3);
        System.out.println("expected3: " + expected3 + ", result3: " + result3);
        var cacheSize4 = 5;
        var cities4 = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome",
                "Paris", "Jeju", "NewYork", "Rome"};
        var expected4 = 52;
        var result4 = sol.solution(cacheSize4, cities4);
        System.out.println("expected4: " + expected4 + ", result4: " + result4);
        var cacheSize5 = 2;
        var cities5 = new String[]{"Jeju", "Pangyo", "NewYork", "newyork"};
        var expected5 = 16;
        var result5 = sol.solution(cacheSize5, cities5);
        System.out.println("expected5: " + expected5 + ", result5: " + result5);
        var cacheSize6 = 0;
        var cities6 = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        var expected6 = 25;
        var result6 = sol.solution(cacheSize6, cities6);
        System.out.println("expected6: " + expected6 + ", result6: " + result6);
    }

    public int solution(int cacheSize, String[] cities) {
        var deque = new ArrayDeque<String>(cacheSize + 1);
        var executionTime = 0;

        for (var city : cities) {
            city = city.toLowerCase();
            if (deque.contains(city)) {
                executionTime += 1;
                deque.remove(city);
                deque.addFirst(city);
            } else {
                executionTime += 5;
                deque.addFirst(city);
            }


            if (deque.size() > cacheSize) {
                deque.removeLast();
            }
        }

        return executionTime;
    }
}

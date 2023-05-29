package problem131127;

import java.util.HashMap;

public class DiscountEvent {
    public static void main(String[] args) {
        var sol = new DiscountEvent();
        var want1 = new String[]{"banana", "apple", "rice", "pork", "pot"};
        var number1 = new int[]{3, 2, 2, 2, 1};
        var discount1 = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork",
                "rice", "pot", "banana", "apple", "banana"};
        var expected1 = 3;
        var result1 = sol.solution(want1, number1, discount1);
        System.out.println("test1: expected:" + expected1 + " result:" + result1);
        var want2 = new String[]{"apple"};
        var number2 = new int[]{10};
        var discount2 = new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
                "banana", "banana"};
        var expected2 = 0;
        var result2 = sol.solution(want2, number2, discount2);
        System.out.println("test2: expected:" + expected2 + " result:" + result2);
    }

    public int solution(String[] want, int[] number, String[] discount) {
        var days = 10;
        var possibleDays = 0;

        for (var i = 0; i < discount.length - days + 1; i++) {
            var quantity = 0;
            var quantityMap = new HashMap<String, Integer>();
            for (var j = 0; j < want.length; j++) {
                quantityMap.put(want[j], number[j]);
                quantity += number[j];
            }

            if (!quantityMap.containsKey(discount[i])) {
                continue;
            }

            for (var j = 0; j < days; j++) {
                var product = discount[i + j];
                if (quantityMap.containsKey(product)) {
                    if (quantityMap.get(product) - 1 == 0) {
                        quantityMap.remove(product);
                    } else {
                        quantityMap.put(product, quantityMap.get(product) - 1);
                    }
                    quantity--;
                }
            }

            if (quantity == 0) {
                possibleDays++;
            }
        }

        return possibleDays;
    }
}

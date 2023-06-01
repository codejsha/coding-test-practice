package problem42577;

import java.util.Arrays;
import java.util.HashSet;

public class PhoneNumberList {
    public static void main(String[] args) {
        var sol = new PhoneNumberList();
        var phone_book1 = new String[]{"119", "97674223", "1195524421"};
        var expected1 = false;
        var result1 = sol.solution(phone_book1);
        System.out.println("test1: result : " + result1 + ", expected : " + expected1);
        var phone_book2 = new String[]{"123", "456", "789"};
        var expected2 = true;
        var result2 = sol.solution(phone_book2);
        System.out.println("test2: result : " + result2 + ", expected : " + expected2);
        var phone_book3 = new String[]{"12", "123", "1235", "567", "88"};
        var expected3 = false;
        var result3 = sol.solution(phone_book3);
        System.out.println("test3: result : " + result3 + ", expected : " + expected3);
    }

    public boolean solution(String[] phone_book) {
        var map = new HashSet<>(Arrays.asList(phone_book));

        for (var pNumber : phone_book) {
            for (var i = 0; i < pNumber.length(); i++) {
                if (map.contains(pNumber.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}

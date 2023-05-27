package problem12953;

public class NLeastCommonMultiple {
    public static void main(String[] args) {
        var sol = new NLeastCommonMultiple();
        var arr1 = new int[] { 2, 6, 8, 14 };
        var result1 = 168;
        var actual1 = sol.solution(arr1);
        System.out.println("test1: " + actual1 + " " + (result1 == actual1));
        var arr2 = new int[] { 1, 2, 3 };
        var result2 = 6;
        var actual2 = sol.solution(arr2);
        System.out.println("test2: " + actual2 + " " + (result2 == actual2));
    }

    public int solution(int[] arr) {
        var v = 1;
        for (var e : arr) {
            v = lcm(v, e);
        }
        return v;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            var temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}

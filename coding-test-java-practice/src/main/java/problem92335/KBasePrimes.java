package problem92335;

public class KBasePrimes {
    public static void main(String[] args) {
        var sol = new KBasePrimes();
        var n1 = 437674;
        var k1 = 3;
        var expected1 = 3;
        var result1 = sol.solution(n1, k1);
        System.out.println("test1: expected: " + expected1 + ", result: " + result1);
        var n2 = 110011;
        var k2 = 10;
        var expected2 = 2;
        var result2 = sol.solution(n2, k2);
        System.out.println("test2: expected: " + expected2 + ", result: " + result2);
    }

    public int solution(int n, int k) {
        var arr = Integer.toString(n, k).split("0");

        var count = 0;
        for (var num : arr) {
            if (num.length() >= 1 && isPrime(Long.parseLong(num))) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

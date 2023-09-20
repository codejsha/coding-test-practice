package problem12979;

public class BaseStationInstallation {
    public static void main(String[] args) {
        var sol = new BaseStationInstallation();
        var n1 = 11;
        var stations1 = new int[]{4, 11};
        var w1 = 1;
        var expected1 = 3;
        var result1 = sol.solution(n1, stations1, w1);
        System.out.println("test1: expected: " + expected1 + ", result: " + result1);
        var n2 = 16;
        var stations2 = new int[]{9};
        var w2 = 2;
        var expected2 = 3;
        var result2 = sol.solution(n2, stations2, w2);
        System.out.println("test2: expected: " + expected2 + ", result: " + result2);
    }

    private static int needStationCount(int n, int w) {
        return (int) Math.ceil((double) n / (2 * w + 1));
    }

    public int solution(int n, int[] stations, int w) {
        if (stations.length == 0) {
            return needStationCount(n, w);
        }

        var needCount = 0;
        var index = 0;
        var boundary = stations[index] - w;
        var shadow = 1;

        while (true) {
            if (boundary - shadow > 0) {
                needCount += needStationCount(boundary - shadow, w);
            }
            shadow = boundary + 2 * w + 1;
            if (shadow > n) {
                break;
            }

            if (index < stations.length - 1) {
                index++;
                boundary = stations[index] - w;
            } else {
                needCount += needStationCount(n - shadow + 1, w);
                break;
            }
        }

        return needCount;
    }
}

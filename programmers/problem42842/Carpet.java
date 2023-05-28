package problem42842;

public class Carpet {
    public static void main(String[] args) {
        var sol = new Carpet();
        var brown1 = 10;
        var yellow1 = 2;
        var result1 = sol.solution(brown1, yellow1);
        System.out.println(result1[0] + ", " + result1[1]);
        var brown2 = 8;
        var yellow2 = 1;
        var result2 = sol.solution(brown2, yellow2);
        System.out.println(result2[0] + ", " + result2[1]);
        var brown3 = 24;
        var yellow3 = 24;
        var result3 = sol.solution(brown3, yellow3);
        System.out.println(result3[0] + ", " + result3[1]);
    }

    public int[] solution(int brown, int yellow) {
        var answer = new int[2];
        for (var i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                var width = yellow / i;
                var height = i;
                if (2 * (width + height + 2) == brown) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    break;
                }
            }
        }
        return answer;
    }
}

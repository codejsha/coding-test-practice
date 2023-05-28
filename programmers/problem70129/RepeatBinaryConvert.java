package problem70129;

public class RepeatBinaryConvert {
    public static void main(String[] args) {
        var sol = new RepeatBinaryConvert();
        var result = sol.solution("110010101001");
        for (var i : result) {
            System.out.println(i);
        }
    }

    public int[] solution(String s) {
        var answer = new int[2];
        var count = 0;
        var zeroCount = 0;

        while (!s.equals("1")) {
            count++;
            var len = s.length();
            s = s.replaceAll("0", "");
            zeroCount += len - s.length();
            s = Integer.toBinaryString(s.length());
        }

        answer[0] = count;
        answer[1] = zeroCount;

        return answer;
    }
}

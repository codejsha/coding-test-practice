package problem70129;

public class RepeatBinaryConvert {
    public static void main(String[] args) {
        var sol = new RepeatBinaryConvert();
        int[] result = sol.solution("110010101001");
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            count++;
            int len = s.length();
            s = s.replaceAll("0", "");
            zeroCount += len - s.length();
            s = Integer.toBinaryString(s.length());
        }

        answer[0] = count;
        answer[1] = zeroCount;

        return answer;
    }
}

package problem12951;

public class JadenCase_Array {
    public static void main(String[] args) {
        var sol = new JadenCase_Array();
        var s1 = "3people unFollowed me  ";
        System.out.println(sol.solution(s1));
        var s2 = "for The Last Week";
        System.out.println(sol.solution(s2));
    }

    public String solution(String s) {
        var lowerArr = s.toLowerCase().split("");
        var flag = true;

        var sb = new StringBuilder();
        for (var letter : lowerArr) {
            if (flag) {
                sb.append(letter.toUpperCase());
            } else {
                sb.append(letter);
            }
            flag = letter.equals(" ");
        }
        return sb.toString();
    }
}

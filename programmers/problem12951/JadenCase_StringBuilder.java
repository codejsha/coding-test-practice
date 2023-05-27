package problem12951;

public class JadenCase_StringBuilder {
    public static void main(String[] args) {
        var sol = new JadenCase_Array();
        var s1 = "3people unFollowed me  ";
        System.out.println(sol.solution(s1));
        var s2 = "for The Last Week";
        System.out.println(sol.solution(s2));
    }

    public String solution(String s) {
        var sb = new StringBuilder();
        var lower = s.toLowerCase();

        if (Character.isLetter(s.charAt(0))) {
            sb.append(Character.toUpperCase(s.charAt(0)));
        } else {
            sb.append(s.charAt(0));
        }

        for (var i = 1; i < lower.length(); i++) {
            if (lower.charAt(i - 1) == ' ') {
                sb.append(Character.toUpperCase(lower.charAt(i)));
            } else {
                sb.append(lower.charAt(i));
            }
        }
        return sb.toString();
    }
}

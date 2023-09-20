package problem17686;

import java.util.Arrays;

public class FileNameSorting {
    public static void main(String[] args) {
        final var sol = new FileNameSorting();
        final var files = new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        final var expected = new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};
        final var result = sol.solution(files);
        System.out.println("expected: " + Arrays.toString(expected) + " result: " + Arrays.toString(result));
    }

    private static int compare(String o1, String o2) {
        final var head1 = o1.split("[0-9]+")[0].toLowerCase();
        final var head2 = o2.split("[0-9]+")[0].toLowerCase();
        if (head1.equals(head2)) {
            final var number1 = Integer.parseInt(o1.split("[^0-9]+")[1]);
            final var number2 = Integer.parseInt(o2.split("[^0-9]+")[1]);
            return number1 - number2;
        }
        return head1.compareTo(head2);
    }

    public String[] solution(String[] files) {
        Arrays.sort(files, FileNameSorting::compare);
        return files;
    }
}

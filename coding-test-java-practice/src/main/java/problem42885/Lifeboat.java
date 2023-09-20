package problem42885;

import java.util.Arrays;

public class Lifeboat {
    public static void main(String[] args) {
        var lifeboat = new Lifeboat();
        var arr1 = new int[]{70, 50, 80, 50};
        var limit1 = 100;
        System.out.println(lifeboat.solution(arr1, limit1));
        var arr2 = new int[]{70, 80, 50};
        var limit2 = 100;
        System.out.println(lifeboat.solution(arr2, limit2));
    }

    public int solution(int[] people, int limit) {
        var answer = 0;
        var weight = 0;
        var head = 0;
        var tail = people.length - 1;
        Arrays.sort(people);

        while (head <= tail) {
            if (weight + people[tail] <= limit) {
                weight += people[tail];
                tail--;
            }

            while (head <= tail && weight <= limit) {
                if (weight + people[head] <= limit) {
                    weight += people[head];
                    head++;
                } else {
                    break;
                }
            }

            answer++;
            weight = 0;
        }
        return answer;
    }
}

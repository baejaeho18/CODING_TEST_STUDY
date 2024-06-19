import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        for (int min = 0, max = people.length - 1; min <= max; max--) {
            answer++;
            // if (min == max) continue;
            if (people[min] + people[max] <= limit) min++;
        }
        return answer;
    }
}
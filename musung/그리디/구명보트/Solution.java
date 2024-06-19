import java.util.Arrays;
class Solution {
    // 구명보트 2명, 무게제한
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int maxIdx = people.length-1;
        int minIdx = 0;
        int count = 0;
        while(minIdx <= maxIdx) {
            int maxValue = people[maxIdx];
            int minValue = people[minIdx];
            if(maxValue + minValue <= limit) {
                maxIdx--;
                minIdx++;
                count++;
            } else if(maxValue <= limit) {
                maxIdx--;
                count++;
            }
        }
        int answer = count;
        return answer;
    }
}
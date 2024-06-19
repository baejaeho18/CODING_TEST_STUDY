import java.util.Arrays;
import java.util.ArrayList;
import java.lang.StringBuilder;
class Solution {
    static ArrayList<Integer> numbers;
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        numbers = new ArrayList<>();
        makeBig(number,0,k);
        for(int i : numbers) {
            sb.append(i);
        }
        String answer = sb.toString();
        return answer;
    }
    // 1. 가장 큰 수, 뺄거
    public void makeBig(String number,int start, int k) {
        if(k == 0) {
            for(int i = start; i < number.length(); i++) {
                numbers.add((int) number.charAt(i) - '0');
            }
            return;
        }
        if( k == number.length()-start) return;
        int maxIdx = start;
        for(int i = start; i <= start + k; i++) {
            if(number.charAt(i) > number.charAt(maxIdx)) {
                maxIdx = i;
            }
        }
        numbers.add(number.charAt(maxIdx) - '0');
        makeBig(number,maxIdx + 1, k - (maxIdx - start));
    }

}

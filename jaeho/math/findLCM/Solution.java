import java.util.HashMap;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        HashMap<Integer,Integer> elements = new HashMap<Integer,Integer>();
        int[] primes = {2,3,5,7,11,13,15,17,19,23,29,31,37,41,43};
        for (int num : arr) {
            // for (int i = 1; i <= num; i++) {
            for (int i : primes){
                int cnt = 0;
                while (num % i == 0) {
                    num /= i;
                    cnt++;
                }
                if (cnt != 0 && (!elements.containsKey(i) || elements.get(i) < cnt)) {
                    elements.put(i, cnt);
                    System.out.print(num);
                    System.out.print(i);
                    System.out.println(cnt);
                }
            }
        }
        
        for (int key : elements.keySet()) {
            for (int i = 0; i < elements.get(key); i++)
                answer *= key;
        }
        return answer;
    }
}
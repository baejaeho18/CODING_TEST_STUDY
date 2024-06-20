class Solution {
    public String solution(String number, int k) {
        String answer = "";

        while (0 < k) {
            if (k == number.length()) {
                number = "";
                break;
            }

            int max = 0, idx = 0;
            for (int i = 0; i < k+1; i++) {
                int tmp = (int)number.charAt(i);
                if (tmp == 9) {
                    idx = i;
                    break;
                }
                if (max < tmp) {
                    max = tmp;
                    idx = i;
                }
            }
            answer += number.charAt(idx);
            number = number.substring(idx+1);
            k -= idx;
        }
        
        answer += number;
        return answer;
    }
}
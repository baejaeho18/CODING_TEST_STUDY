class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey != 0) {
            int move = storey % 10;
            storey /= 10;
            if (10 - move < move) {
                storey += 1;
                answer += 10 - move;
            }
            else if (10 - move == move) {
                if (storey % 10 >= 5) storey += 1;
                answer += move;
            }
            else {
                answer += move;
            }
        }
        return answer;
    }
}
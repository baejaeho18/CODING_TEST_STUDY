class Solution {
    //1. 이모티콘 플러스 가입자 수를 늘린다.
    //2. 판매액을 늘린다.
    static int[] discount;
    static int[] answer;
    public int[] solution(int[][] users, int[] emoticons) {
        discount = new int[emoticons.length];
        answer = new int[2];
        dfs(0,users,emoticons);
        return answer;
    }
    public void dfs(int level,int[][] users, int[] emoticons) {
        if(level == discount.length) {
            int[] ans = findAns(users,emoticons);
            if(ans[0] > answer[0]) {
                answer[0] = ans[0];
                answer[1] = ans[1];
            }
            if(ans[0] == answer[0] && ans[1] > answer[1]) {
                answer[1] = ans[1];
            }
            return;
        }
        for(int j = 1; j <= 4; j++) {
            discount[level] = j;
            dfs(level+1,users,emoticons);
        }
    }
    public int[] findAns(int[][] users,int[] emoticons) {
        int[] persons = new int[users.length];
        int[] answer = new int[2];
        for(int i = 0; i < users.length; i++) {
            for(int j = 0; j < emoticons.length; j++) {
                if(discount[j]*10 < users[i][0]) continue;
                persons[i] += emoticons[j] * (10-discount[j]) / 10;
                if(persons[i] >= users[i][1]) {
                    answer[0]++;
                    break;
                }
            }
            if(persons[i] < users[i][1]) answer[1] += persons[i];;
        }
        return answer;
    }
}
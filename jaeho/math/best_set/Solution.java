class Solution {
    public int[] solution(int n, int s) {
        int[] err = {-1};
        int base = s / n;
        if (base == 0) return err;
        int[] answer = new int[n];
        int diff = s - base * n;
        for (int i = 0; i < n; i++) {
            if (n - diff <= i)
                answer[i] = base + 1;
            else
                answer[i] = base;
        }
        return answer;
    }
}
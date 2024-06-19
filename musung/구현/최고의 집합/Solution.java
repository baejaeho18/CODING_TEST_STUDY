import java.util.Arrays;
class Solution {
    public int[] solution(int n, int s) {
        int[] nums = new int[n];
        if(s/n == 0) return new int[]{-1};
        Arrays.fill(nums,s/n);
        int k = s%n;
        for(int i = 0; i < k; i++) {
            nums[nums.length-i-1]++;
        }
        int[] answer = nums;
        return answer;
    }
}

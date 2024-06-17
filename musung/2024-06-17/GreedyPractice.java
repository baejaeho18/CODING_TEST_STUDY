class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int storey = 666;
        int count = 0;
        int n = 1;
        while(storey != 0) {
            int k = (int) (storey % Math.pow(10,n)/Math.pow(10,n-1));
            if(k > 5) {
                storey += (10-k) * Math.pow(10,n-1);
                count += (10-k);
            } else {
                storey -= k * Math.pow(10,n-1);
                count += k;
            }
            n++;
        }
        System.out.println(count);
        return count;
    }
}
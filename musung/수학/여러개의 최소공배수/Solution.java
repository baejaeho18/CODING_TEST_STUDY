import java.lang.Math;
class Solution {
    public int solution(int[] arr) {
        int pre = arr[0];
        for(int i = 1; i < arr.length; i++) {
            pre = lcm(arr[i],pre);
        }
        return pre;
    }
    public int gcd(int n, int k) {
        if(n%k == 0) return k;
        return gcd(k,n%k);
    }
    public int lcm(int n, int k) {
        return (n*k)/gcd(n,k);
    }
}
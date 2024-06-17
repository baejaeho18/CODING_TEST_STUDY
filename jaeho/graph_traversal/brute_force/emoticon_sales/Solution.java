class Solution {
    static int[] discountable_rate = {0, 10, 20, 30, 40};
    static int total_subscribe = 0, total_price = 0, min_rate = 100;
    
    private int sale(int price, int sale_rate) { return price * (100 - sale_rate) / 100; }

    private void userDo(int[][] users, int[] emoticons, int[] discounts) {
        int subscribe = 0; 
        int price = 0; 
        
        for (int[] user : users) {
            int sum = 0;
            
            for (int i = 0; i < discounts.length; i++) {
                if (discounts[i] < user[0]) continue;
                sum += sale(emoticons[i], discounts[i]);
            }
            
            if (user[1] <= sum) subscribe++;
            else price += sum;
        }
        
        if (total_subscribe < subscribe) {
            total_subscribe = subscribe;
            total_price = price;
        } else if (subscribe == total_subscribe && price > total_price) {
            total_price = price;
        }
    }

    private void setDiscounts(int[] discounts, int cnt, int e, int[][] users, int[] emoticons) {
        if (cnt == e) {
            userDo(users, emoticons, discounts);
            return;
        }
        
        for (int i = cnt; i < e; i++) {
            for (int rate : discountable_rate) {
                if (rate < min_rate) continue;
                discounts[i] = rate;
                setDiscounts(discounts, i+1, e, users, emoticons);
            }
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        for (int[] user : users) {
            if (user[0] < min_rate)
                min_rate = user[0];
        }
        for (int rate : discountable_rate) {
            if (min_rate <= rate)  {
                min_rate = rate;
                break;
            }
        }
        
        int[] discounts = new int[emoticons.length];
        setDiscounts(discounts, 0, emoticons.length, users, emoticons);
        
        int[] answer = {total_subscribe, total_price};
        return answer;
    }
}
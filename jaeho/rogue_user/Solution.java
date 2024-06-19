import java.util.ArrayList;

class Solution {
    // find out matching_ids from banned_id
    private ArrayList<String> matchingIds(String[] user_ids, String banned_id) {
        ArrayList<String> output = new ArrayList<>();
        for (String user_id : user_ids){
            int length = user_id.length();
            if (length != banned_id.length()) continue;
            for (int i = 0; i < length; i++) {
                if (!(user_id.valueOf(i).equals(banned_id.valueOf(i)) && banned_id.valueOf(i).equals("*")))
                    break;
                if (i == length - 1)
                    output.add(user_id);
            }
        }
        return output;
    }

    // calculate combination
    private int calCombination(ArrayList<ArrayList<String>> banned_ids) {
        int comb = 0;
        int size = banned_ids.size();
        String[][] banned_ids_list 
        banned_ids.get(0)

        return 0;
    }


    public int solution(String[] user_id, String[] banned_id) {
        ArrayList<String>[banned_id.length()] banned_ids = new ArrayList<>();
        for (String ban_id : banned_id)
            banned_ids.add(matchingIds(user_id, ban_id));

        int answer = calCombination(banned_ids);
        return answer;
    }
}
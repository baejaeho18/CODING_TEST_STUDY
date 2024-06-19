import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
class Solution {
    static HashSet<HashSet<String>> set = new HashSet<>();
    static boolean[] visited;
    static String[] userId;
    static String[] bannedId;
    public int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId = banned_id;
        visited = new boolean[user_id.length];
        dfs(new HashSet<String>(),0);
        int answer = set.size();
        return answer;
    }
    // banned_id 1번부터 시작해서 dfs, dfs가 banned_id가 되면 count++;
    public void dfs(HashSet<String> curSet, int level) {
        if(level == bannedId.length) {
            set.add(curSet);
            return;
        }
        for(int i = 0; i < userId.length; i++) {
            if(curSet.contains(userId[i])) continue;
            if(!isMatch(userId[i],bannedId[level])) continue;
            curSet.add(userId[i]);
            dfs(new HashSet<String>(curSet),level + 1);
            curSet.remove(userId[i]);
        }
    }
    public boolean isMatch(String o1, String o2) {
        if(o1.length() != o2.length()) return false;
        for(int i = 0; i < o1.length(); i++) {
            if(o2.charAt(i) == '*') continue;
            if(o1.charAt(i) != o2.charAt(i)) return false;
        }
        return true;
    }
}
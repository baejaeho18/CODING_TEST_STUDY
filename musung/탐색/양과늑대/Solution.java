import java.lang.Math;
class Solution {
    static int max;
    public int solution(int[] info, int[][] edges) {
        boolean visited[] = new boolean[info.length];
        dfs(0,0,0,visited,info,edges);
        int answer = max;
        return answer;
    }
    public void dfs(int cur, int sheep, int wolf, boolean[] visited, int[] info, int[][] edges) {
        visited[cur] = true;
        if(info[cur] == 0) {
            sheep++;
            max = Math.max(max,sheep);
        }if(info[cur] == 1) {
            wolf++;
        }if(sheep <= wolf) return;
        for(int[] edge : edges) {
            if(visited[edge[0]] && !visited[edge[1]]) {
                boolean[] newVisited = visited.clone();
                dfs(edge[1],sheep,wolf,newVisited,info,edges);
            }
        }
    }
}
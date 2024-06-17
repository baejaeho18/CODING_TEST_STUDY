class Solution {
    static int maxSheepCnt = 0;

    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        nodeTraversal(info, edges, 0, visited, 0, 0);
        return maxSheepCnt;
    }

    private void nodeTraversal(int[] info, int[][] edges, int node, boolean[] visited, int sheepCnt, int wolfCnt) {
        visited[node] = true;
        if (info[node] == 0) sheepCnt++;
        else wolfCnt++;

        if (sheepCnt <= wolfCnt) return;
        if (maxSheepCnt < sheepCnt) maxSheepCnt = sheepCnt;

        for (int[] edge : edges) {
            if (visited[edge[0]] && !visited[edge[1]]) {    // if child
            	boolean[] visitedBranch = new boolean[visited.length];
            	for (int i = 0; i < visited.length; i++)
                	visitedBranch[i] = visited[i];
                nodeTraversal(info, edges, edge[1], visitedBranch, sheepCnt, wolfCnt);
            }
        }
    }
}
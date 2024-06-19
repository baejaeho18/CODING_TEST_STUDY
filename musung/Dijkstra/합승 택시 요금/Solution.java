import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
class Solution {
    static ArrayList<Node>[] arr;
    static int[][] aTob;
    static int num;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        num = n;
        arr = new ArrayList[n+1];
        aTob = new int[n+1][n+1];
        for(int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i = 1; i <= n; i++) {
            Arrays.fill(aTob[i],Integer.MAX_VALUE);
        }
        for(int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int value = fare[2];
            arr[start].add(new Node(end,value));
            arr[end].add(new Node(start,value));
        }
        dijkstra(s);
        dijkstra(a);
        dijkstra(b);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            min = Math.min(aTob[s][i] + aTob[a][i] + aTob[b][i],min);
        }
        int answer = min;
        return answer;
    }
    public void dijkstra(int s) {
        // 시작 노드 -> 방문하지 않은 노드 중 가장 비용 적은 노드
        boolean[] visited = new boolean[num+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.cost - b.cost);
        aTob[s][s] = 0;
        pq.offer(new Node(s,0));
        while(!pq.isEmpty()) {
            int cur = pq.poll().index;
            if(visited[cur]) continue;
            visited[cur] = true;
            for(Node next : arr[cur]) {
                if(aTob[s][next.index] > aTob[s][cur] + next.cost) {
                    aTob[s][next.index] = aTob[s][cur] + next.cost;
                    pq.offer(new Node(next.index,aTob[s][next.index]));
                }
            }
        }
    }
    class Node {
        int index;
        int cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
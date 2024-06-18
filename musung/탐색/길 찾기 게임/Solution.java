import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    static PriorityQueue<Node> pq;
    static ArrayList<Node>[] nodes;
    static ArrayList<Integer> front;
    static ArrayList<Integer> back;
    static boolean[] visited;
    public int[][] solution(int[][] nodeinfo) {
        front = new ArrayList<>();
        back = new ArrayList<>();
        pq = new PriorityQueue<>((o1,o2)-> {
            if(o1.y == o2.y) return o1.x - o2.x;
            return o2.y - o1.y;
        });
        visited = new boolean[nodeinfo.length + 1];
        for(int i = 0; i < nodeinfo.length; i++) {
            pq.add(new Node(i+1,nodeinfo[i][0] , nodeinfo[i][1]));
        }
        nodes = new ArrayList[pq.peek().y + 1];
        for(int i = 0; i <= pq.peek().y; i++) {
            nodes[i] = new ArrayList();
        }
        int depth = 0;
        int preY = pq.peek().y;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.y == preY) {
                nodes[depth].add(cur);
            } else {
                nodes[++depth].add(cur);
            }
            preY = cur.y;
        }
        dfs(0,100001,0,nodes[0].get(0));
        int[] frontArr = front.stream().mapToInt(i->i).toArray();
        int[] backArr = back.stream().mapToInt(i->i).toArray();
        int[][] answer = {frontArr,backArr};
        return answer;
    }
    public void dfs(int left, int right, int depth, Node cur) {
        visited[cur.index] = true;
        front.add(cur.index);
        if(depth + 1 < nodes.length) {
            for(Node next : nodes[depth + 1]) {
                if(visited[next.index]) continue;
                if(next.x  < left || next.x > right) continue;
                //left
                if(next.x < cur.x) {
                    dfs(left,cur.x,depth+1,next);
                }
                //right
                if(next.x > cur.x) {
                    dfs(cur.x,right,depth+1,next);
                }
            }
        }
        back.add(cur.index);
    }

    class Node {
        int index;
        int x;
        int y;
        public Node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }

}
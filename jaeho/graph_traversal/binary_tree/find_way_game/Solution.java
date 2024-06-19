import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    class Node implements Comparable<Node> {
        int x;
        int y;
        int idx;

        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y == o.y)
                return o.x - this.x;
            return o.y - this.y;
        }
    }
    
    class Tree {
        Node root;
        Tree left = null;
        Tree right = null;

        Tree(PriorityQueue<Node> graph) {
            this.root = graph.poll();
            PriorityQueue<Node> lefts = new PriorityQueue<>();
            PriorityQueue<Node> rights = new PriorityQueue<>();
            while(!graph.isEmpty()) {
                Node tmp = graph.poll();
                if (tmp.x < this.root.x) lefts.add(tmp);
                if (tmp.x > this.root.x) rights.add(tmp);
            }
            if (!lefts.isEmpty()) this.left = new Tree(lefts);
            if (!rights.isEmpty()) this.right = new Tree(rights);
        }
        
        public ArrayList<Integer> getPreOrder() {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.idx);
            if (left != null) output.addAll(left.getPreOrder());
            if (right != null) output.addAll(right.getPreOrder());
            return output;
        }

        public ArrayList<Integer> getPostOrder() {
            ArrayList<Integer> output = new ArrayList<>();
            if (left != null) output.addAll(left.getPostOrder());
            if (right != null) output.addAll(right.getPostOrder());
            output.add(root.idx);
            return output;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        int cnt = 1;
        for (int[] node : nodeinfo)
            nodes.add(new Node(node[0], node[1], cnt++));

        Tree graph = new Tree(nodes);
        int[] preorder = graph.getPreOrder().stream().mapToInt(Integer::intValue).toArray();
        int[] postorder = graph.getPostOrder().stream().mapToInt(Integer::intValue).toArray();

        int[][] answer = {preorder, postorder};
        return answer;
    }
}
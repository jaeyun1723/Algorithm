import java.util.*;

class Solution {
    static Node[] tree;
    static int[][] answer;
    static int idx;

    public void makeTree(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else
                makeTree(parent.left, child);
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else
                makeTree(parent.right, child);
        }
    }

    public void preOrder(Node node) {
        answer[0][idx++] = node.label;
        if (node.left != null)
            preOrder(node.left);
        if (node.right != null)
            preOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node.left != null)
            postOrder(node.left);
        if (node.right != null)
            postOrder(node.right);
        answer[1][idx++] = node.label;
    }

    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        tree = new Node[nodeinfo.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(tree, (o1, o2) -> {
            if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
            return Integer.compare(o2.y, o1.y);
        });

        for (int i = 1; i < tree.length; i++) {
            makeTree(tree[0], tree[i]);
        }

        preOrder(tree[0]);
        idx = 0;
        postOrder(tree[0]);
        return answer;
    }

    public class Node {
        int label;
        int x;
        int y;
        Node left = null;
        Node right = null;

        public Node(int label, int x, int y) {
            this.label = label;
            this.x = x;
            this.y = y;
        }
    }
}
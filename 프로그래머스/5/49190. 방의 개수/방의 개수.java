import java.util.*;

class Solution {

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static List<Node> EdgeList(Node node) {
        List<Node> list = new ArrayList<>();
        list.add(node);
        return list;
    }

    public int solution(int[] arrows) {

        int answer = 0;

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        Node curNode = new Node(0, 0);

        Map<Node, List<Node>> map = new HashMap<>();

        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) {
                Node nextNode = new Node(curNode.x + dx[arrow], curNode.y + dy[arrow]);

                // 처음 방문
                if (!map.containsKey(nextNode)) {
                    map.put(nextNode, EdgeList(curNode));
                    if (map.get(curNode) == null) {
                        map.put(curNode, EdgeList(nextNode));
                    } else {
                        map.get(curNode).add(nextNode);
                    }
                } else if (!map.get(nextNode).contains(curNode)) { // 재방문 + 처음 간선 통과
                    map.get(nextNode).add(curNode);
                    map.get(curNode).add(nextNode);
                    answer++;
                }

                curNode = nextNode;
            }

        }

        return answer;
    }
}
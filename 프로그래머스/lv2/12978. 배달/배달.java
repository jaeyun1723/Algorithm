import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    static class Node {

        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // N개의 마을, K시간 이하로 배달
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }
        int[] dist = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new Node(1, 0));
        dist[1] = 0;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (dist[curNode.idx] < curNode.cost) {
                continue;
            }
            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node next = graph.get(curNode.idx).get(i);
                if (dist[next.idx] > curNode.cost + next.cost) {
                    dist[next.idx] = curNode.cost + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(dist[i]+" ");
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}
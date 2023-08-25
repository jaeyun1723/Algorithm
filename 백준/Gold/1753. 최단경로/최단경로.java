import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int idx, cost;

		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		public int compareTo(Node o1) {
			return this.cost - o1.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		for (int i = 0; i <= V; i++)
			list.add(new ArrayList<Node>());
		int start = Integer.parseInt(st.nextToken());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(u).add(new Node(v, w));
		}
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] isVisit = new boolean[V + 1];
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (isVisit[now.idx])
				continue;
			isVisit[now.idx] = true;
			for (Node next : list.get(now.idx)) {
				if (dist[next.idx] > dist[now.idx] + next.cost) {
					dist[next.idx] = dist[now.idx] + next.cost;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		for (int i = 1; i <= V; i++)
			if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
	}

}
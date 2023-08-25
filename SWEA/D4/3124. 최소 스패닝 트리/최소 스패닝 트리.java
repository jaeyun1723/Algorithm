import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int[] vertex;

	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		long edge;

		Edge(int v1, int v2, long edge) {
			this.v1 = v1;
			this.v2 = v2;
			this.edge = edge;
		}

		public int compareTo(Edge o1) {
			return (int) (this.edge - o1.edge);
		}

	}

	static int find(int v) {
		if (vertex[v] == v)
			return v;
		return vertex[v] = find(vertex[v]);
	}

	static void union(int v1, int v2) {
		int rt1 = find(v1);
		int rt2 = find(v2);
		if (rt1 != rt2)
			vertex[rt1] = vertex[rt2];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			vertex = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				vertex[i] = i;
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				long edge = Long.parseLong(st.nextToken());
				pq.add(new Edge(A, B, edge));
			}
			int edgeCnt = 0;
			long sum = 0;
			while (!pq.isEmpty()) {
				Edge now = pq.poll();
				if (find(now.v1) == find(now.v2))
					continue;
				union(now.v1, now.v2);
				edgeCnt++;
				sum += now.edge;
			}
			System.out.println("#" + t + " " + sum);

		}

	}//

}//
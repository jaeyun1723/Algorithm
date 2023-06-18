import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int from, to, weight;

		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	static int V, E;
	static int[] parents;

	static void make() {
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++)
			parents[i] = i;
	}

	static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot)
			return false;
		parents[yRoot] = xRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ArrayList<Edge> mst = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			mst.add(new Edge(v1, v2, edge));
		}

		make();
		Collections.sort(mst, (o1, o2) -> o1.weight - o2.weight);

		long sum = 0;
		int cnt = 0;
		for (Edge e : mst) {
			if (union(e.from, e.to)) {
				cnt++;
				sum += e.weight;
				if(cnt==V-1) break;
			}
		}
		System.out.println(sum);
	}// etc

}// etc

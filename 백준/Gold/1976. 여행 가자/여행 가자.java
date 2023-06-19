import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] city;
	static int[] plan, parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		city = new int[n + 1][n + 1];
		parent = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++)
			parent[i] = i;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1)
					union(i, j);
			}
		}

		st = new StringTokenizer(br.readLine());
		plan = new int[m + 1];
		for (int i = 0; i < m; i++)
			plan[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < m; i++) {
			if (parent[plan[i - 1]] != parent[plan[i]]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}// etc

	static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot > yRoot)
			parent[xRoot] = yRoot;
		else
			parent[yRoot] = xRoot;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}
}// etc
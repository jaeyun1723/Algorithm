import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, m;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 0; i <= n; i++)
			parent[i] = i;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int set1 = Integer.parseInt(st.nextToken());
			int set2 = Integer.parseInt(st.nextToken());
			if (num == 0)
				union(set1, set2);
			else
				isSame(set1, set2);
		}
	}// etc

	static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		parent[xRoot] = yRoot;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	static void isSame(int x, int y) {
		if (find(x) == find(y))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}// etc
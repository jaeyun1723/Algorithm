import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] parents;

	static void makeSet() {
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]); // # 부모를 루트노드로 변경
		// 루트노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parents = new int[n + 1];
			makeSet();
			System.out.print("#" + t + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int CASE = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (CASE == 0)
					union(a, b);
				if (CASE == 1) {
					if (find(a) == find(b))
						System.out.print(1);
					else
						System.out.print(0);
				}
			}

			System.out.println();
		}

	}//

}//
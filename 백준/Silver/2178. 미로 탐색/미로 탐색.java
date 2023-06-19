
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] miro, dp;
	static int N, M;
	static boolean[][] isVisited;
	static int[] x = { -1, 1, 0, 0 }, y = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new int[N][M];
		dp = new int[N][M];
		isVisited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < str.length(); j++) {
				miro[i][j] = str.charAt(j) - '0';
			}
		}
		dp[0][0] = 1;
		bfs();

		System.out.println(dp[N - 1][M - 1]);
	}// etc

	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		isVisited[0][0] = true;
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int idx = 0; idx < 4; idx++) {
				// 상 하 좌 우
				int xx = now[0] + x[idx];
				int yy = now[1] + y[idx];
				if (xx < 0 || yy < 0 || xx >= N || yy >= M || miro[xx][yy] == 0)
					continue;
				if (!isVisited[xx][yy] && miro[xx][yy] == 1) {
					isVisited[xx][yy] = true;
					dp[xx][yy] = dp[now[0]][now[1]] + 1;
					queue.add(new int[] { xx, yy });
				}
			}
		}
	}
}// etc

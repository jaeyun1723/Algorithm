import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, W, H;
	static int[][] cave;
	static ArrayList<ArrayList<Integer>> brick;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static int bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		pq.add(new int[] { 0, 0, cave[0][0] });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			if (cur[0] == N - 1 && cur[1] == N - 1)
				return cur[2];
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i], ny = cur[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (dp[nx][ny] > cur[2] + cave[nx][ny]) {
					dp[nx][ny] = cur[2] + cave[nx][ny];
					pq.add(new int[] { nx, ny, dp[nx][ny] });
				}
			}
		}
		return dp[N - 1][N - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int cnt = 0;
		while (!str.equals("0")) {
			cnt++;
			N = Integer.parseInt(str);
			cave = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					cave[i][j] = Integer.parseInt(st.nextToken());
			}
			System.out.println("Problem " + cnt + ": " + bfs());
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
		}

	}

}
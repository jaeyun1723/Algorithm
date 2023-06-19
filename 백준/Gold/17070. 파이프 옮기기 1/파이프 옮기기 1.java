import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static boolean[][] isvisit;
	static int[][] pi;
	static int N, cnt;

	static void dfs(int r1, int c1, int r2, int c2) {
		int[] xidx = null, yidx = null;
		if (r2 == N && c2 == N) {
			cnt++;
			return;
		}
		// 1. 현재 가로인지, 세로인지, 대각선인지
		if (r2 - r1 == 0 && c2 - c1 == 1) // 가로
		{
			xidx = new int[] { 0, 1 };
			yidx = new int[] { 1, 1 };
		} else if (r2 - r1 == 1 && c2 - c1 == 0) // 세로
		{
			xidx = new int[] { 1, 1 };
			yidx = new int[] { 0, 1 };
		} else if (r2 - r1 == 1 && c2 - c1 == 1) // 대각선
		{
			xidx = new int[] { 0, 1, 1 };
			yidx = new int[] { 1, 0, 1 };
		}
		// 2. 다음에 갈 곳 정하기
		for (int i = 0; i < xidx.length; i++) {
			int x = r2 + xidx[i];
			int y = c2 + yidx[i];
			if (x < 1 || x > N || y < 1 || y > N || isvisit[x][y] || pi[x][y] == 1)
				continue;
			if (i == xidx.length - 1 && (pi[x - 1][y] == 1 || pi[x][y - 1] == 1))
				continue;
			if (!isvisit[x][y]) {
				isvisit[x][y] = true;
				dfs(r2, c2, x, y);
				isvisit[x][y] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		pi = new int[N + 1][N + 1];
		isvisit = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				pi[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isvisit[1][1] = true;
		isvisit[1][2] = true;
		dfs(1, 1, 1, 2);
		System.out.println(cnt);

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(pipe[i][j]+" ");
//			}
//			System.out.println();
//		}
	}// etc
}// etc
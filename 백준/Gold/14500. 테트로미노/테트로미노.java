import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static boolean[][] visited;
	static int N, M, max;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int[][] ex = { { 0, 0, 0, 1 }, { 1, 1, 1, 0 }, { 0, 1, 2, 1 }, { 0, 1, 2, 1 } };
	static int[][] ey = { { 0, 1, 2, 1 }, { 0, 1, 2, 1 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 } };

	private static void exception(int x, int y) {
		int nx, ny, sum;
		boolean isOut = false;

		for (int i = 0; i < 4; i++) {
			sum = 0;
			isOut = false;
			for (int j = 0; j < 4; j++) {
				nx = x + ex[i][j];
				ny = y + ey[i][j];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					isOut = true;
					continue;
				}
				sum += arr[nx][ny];
			}
			if (!isOut)
				max = Math.max(max, sum);
		}
	}
    
	public static void dfs(int x, int y, int cnt, int sum) {
		if (cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
				continue;
			visited[nx][ny] = true;
			dfs(nx, ny, cnt + 1, sum + arr[nx][ny]);
			visited[nx][ny] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, arr[i][j]);
//				dfs(i, j, arr[i][j], 1);
				visited[i][j] = false;
				exception(i, j);
			}
		}
		System.out.println(max);
	}//
}//
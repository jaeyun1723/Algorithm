import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static char[][] grid;
	static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static boolean[][] isVisit;

	static void colorWeakness(int r, int c) {
		Deque<Point> deq = new ArrayDeque<>();
		deq.offerLast(new Point(r, c));
		while (!deq.isEmpty()) {
			Point now = deq.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || isVisit[nx][ny])
					continue;
				if (grid[now.x][now.y] != grid[nx][ny] && (grid[now.x][now.y] == 'B' || grid[nx][ny] == 'B'))
					continue;
				isVisit[nx][ny] = true;
				deq.offer(new Point(nx, ny));
			}
		}
	}

	static void common(int r, int c) {
		Deque<Point> deq = new ArrayDeque<>();
		deq.offerLast(new Point(r, c));
		isVisit[r][c] = true;
		while (!deq.isEmpty()) {
			Point now = deq.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || isVisit[nx][ny] || grid[nx][ny] != grid[now.x][now.y])
					continue;
				isVisit[nx][ny] = true;
				deq.offer(new Point(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		grid = new char[N][N];
		isVisit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < N; j++) {
				grid[i][j] = str.charAt(j);
			}
		}

		int cCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisit[i][j]) {
					common(i, j);
					cCnt++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(isVisit[i], false);
		}
		int wCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisit[i][j]) {
					colorWeakness(i, j);
					wCnt++;
				}
			}
		}

		System.out.println(cCnt + " " + wCnt);
	}
}
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int K, H, W, answer = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] mx = { -1, 1, 0, 0 }, hx = { -1, -2, 1, 2, -1, -2, 1, 2 };
	static int[] my = { 0, 0, -1, 1 }, hy = { -2, -1, -2, -1, 2, 1, 2, 1 };

	static class Monkey {
		int x, y, k, cnt;

		Monkey(int x, int y, int k, int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}

	static int bfs(int r, int c) {
		boolean[][][] isVisit = new boolean[H][W][K + 1];
		Deque<Monkey> deq = new ArrayDeque<>();
		deq.offerLast(new Monkey(r, c, 0, 0));
		while (!deq.isEmpty()) {
			Monkey now = deq.pollFirst();
			if (now.x == H - 1 && now.y == W - 1) {
				return now.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + mx[i];
				int ny = now.y + my[i];
				if (nx < 0 || ny < 0 || nx >= H || ny >= W || isVisit[nx][ny][now.k] || arr[nx][ny] == 1)
					continue;
				isVisit[nx][ny][now.k] = true;
				deq.offerLast(new Monkey(nx, ny, now.k, now.cnt + 1));
			}
			if (now.k < K) {
				for (int i = 0; i < 8; i++) {
					int nx = now.x + hx[i];
					int ny = now.y + hy[i];
					if (nx < 0 || ny < 0 || nx >= H || ny >= W || isVisit[nx][ny][now.k + 1] || arr[nx][ny] == 1)
						continue;
					isVisit[nx][ny][now.k + 1] = true;
					deq.offerLast(new Monkey(nx, ny, now.k + 1, now.cnt + 1));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs(0,0));

	}
}
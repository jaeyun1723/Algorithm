import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void bfs(int r, int c, char[][] grid, boolean[][] isVisit) {
		Deque<int[]> deq = new ArrayDeque<>();

		deq.add(new int[] {r, c});
		isVisit[r][c] = true;

		while (!deq.isEmpty()) {
			int[] now = deq.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || isVisit[nx][ny]
					|| grid[nx][ny] == '.')
					continue;
				isVisit[nx][ny] = true;
				deq.offerLast(new int[] {nx, ny});
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(bufferedReader.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] grid = new char[H][W];
			boolean[][] isVisit = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(bufferedReader.readLine());
				String str = st.nextToken();
				for (int j = 0; j < W; j++) {
					grid[i][j] = str.charAt(j);
				}
			}
			int res = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (grid[i][j] == '#' && !isVisit[i][j]) {
						res++;
						bfs(i, j, grid, isVisit);
					}
				}
			}
			System.out.println(res);
		}

	}
}
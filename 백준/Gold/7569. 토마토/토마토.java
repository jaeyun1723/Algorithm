import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] tomato = new int[N][M][H];
		Deque<int[]> deq = new ArrayDeque<int[]>();
		boolean[][][] isVisit = new boolean[N][M][H];
		int[] dx = { -1, 1, 0, 0, 0, 0 }, dy = { 0, 0, -1, 1, 0, 0 }, dz = { 0, 0, 0, 0, -1, 1 };
		int answer = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					tomato[j][k][i] = Integer.parseInt(st.nextToken());
					if (tomato[j][k][i] == 1) {
						deq.add(new int[] { j, k, i, 0 });
						isVisit[j][k][i] = true;
					}
				}
			}
		}
		while (!deq.isEmpty()) {
			int[] now = deq.pollFirst();
			for (int i = 0; i < 6; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				int z = now[2] + dz[i];
				answer = Math.max(answer, now[3]);
				if (x < 0 || x >= N || y < 0 || y >= M || z < 0 || z >= H || isVisit[x][y][z] || tomato[x][y][z] != 0)
					continue;
				isVisit[x][y][z] = true;
				tomato[x][y][z] = 1;
				deq.add(new int[] { x, y, z, now[3] + 1 });
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (tomato[j][k][i] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
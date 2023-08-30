import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, answer;
	static int[][] pipe;

	static void movePipe(int r1, int c1, int r2, int c2) {
		int[] dx = null, dy = null;
		// System.out.println(r1 + "," + c1 + " : " + r2 + "," + c2);
		if (r2 == N - 1 && c2 == N - 1) {
			// System.out.println(r2 + "," + c2 + "도착");
			answer++;
			return;
		}
		if (r2 - r1 == 1 && c2 - c1 == 1) { // 대각선
			dx = new int[] { 0, 1, 1 };
			dy = new int[] { 1, 0, 1 };
		} else if (r2 - r1 == 0 && c2 - c1 == 1) { // 가로
			dx = new int[] { 0, 1 };
			dy = new int[] { 1, 1 };
		} else if (r2 - r1 == 1 && c2 - c1 == 0) {
			dx = new int[] { 1, 1 };
			dy = new int[] { 0, 1 };
		}

		for (int i = 0; i < dx.length; i++) {
			int nx = r2 + dx[i];
			int ny = c2 + dy[i];
			if (nx >= N || ny >= N || pipe[nx][ny] == 1)
				continue;
			if (i == dx.length - 1 && (pipe[nx - 1][ny] == 1 || pipe[nx][ny - 1] == 1))
				continue;
			movePipe(r2, c2, nx, ny);

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		pipe = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pipe[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		movePipe(0, 0, 0, 1);
		System.out.println(answer);
	}
}
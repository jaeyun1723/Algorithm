
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static int[][] lab, safe;
	static ArrayList<int[]> virus;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static int[][] deepCopy(int[][] arr) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				tmp[i][j] = arr[i][j];
		return tmp;
	}

	public static void bfs(int[][] arr) {
		Deque<int[]> deq = new ArrayDeque<>();
		for (int i = 0; i < virus.size(); i++)
			deq.add(virus.get(i));
		while (!deq.isEmpty()) {
			int[] vir = deq.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nx = vir[0] + dx[i];
				int ny = vir[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (arr[nx][ny] == 0) {
					arr[nx][ny] = 2;
					deq.add(new int[] { nx, ny });
				}
			}
		}
		int res = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (arr[i][j] == 0)
					res++;
		answer = Math.max(answer, res);
	}

	public static void solution(int cnt) {
		if (cnt == 3) {
			int[][] tmp = deepCopy(lab);
//			for (int i = 0; i < 3; i++)
//				tmp[safe[i][0]][safe[i][1]] = 1;
			bfs(tmp);
			return;
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (lab[i][j] == 0) {
					lab[i][j] = 1;
					solution(cnt + 1);
					lab[i][j] = 0;
				}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		safe = new int[3][2];
		lab = new int[N][M];
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2)
					virus.add(new int[] { i, j });
			}
		}

		solution(0);
		System.out.println(answer);
	}

}

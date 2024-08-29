import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 1. 문제
 * 1번 CCTV는 한 쪽 방향만 감시할 수 있다.
 * 2번은 감시하는 방향이 서로 반대방향이어야 하고
 * 3번은 직각 방향이어야 한다.
 * 4번은 세 방향
 * 5번은 네 방향을 감시할 수 있다.
 * CCTV는 벽을 통과할 수 없다
 * CCTV는 CCTV를 통과할 수 있다.
 * CCTV의 방향을 적절히 정해서, 사각 지대의 최소 크기를 구하는 프로그램을 작성하시오.
 * 
 * 2. 전략
 */
public class Main {

	static class CCTV {
		int x;
		int y;
		int type;

		CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	static int N, M, result = Integer.MAX_VALUE;
	static int[] direction;
	static ArrayList<CCTV> list;

	static void monitorUp(int r, int c, int[][] map) {
		while (--r >= 0 && map[r][c] != 6) {
			if (map[r][c] != 0)
				continue;
			map[r][c] = -1;
		}
	}

	static void monitorDown(int r, int c, int[][] map) {
		while (++r < N && map[r][c] != 6) {
			if (map[r][c] != 0)
				continue;
			map[r][c] = -1;
		}
	}

	static void monitorLeft(int r, int c, int[][] map) {
		while (--c >= 0 && map[r][c] != 6) {
			if (map[r][c] != 0)
				continue;
			map[r][c] = -1;
		}
	}

	static void monitorRight(int r, int c, int[][] map) {
		while (++c < M && map[r][c] != 6) {
			if (map[r][c] != 0)
				continue;
			map[r][c] = -1;
		}
	}

	static int[][] copyMap(int[][] map) {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				tmp[i][j] = map[i][j];
		return tmp;
	}

	static int blindSpot(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	static void dfs(int cnt, int[][] map) {
		if (cnt == list.size()) {
			result = Math.min(result, blindSpot(map));
			return;
		}
		int[][] tmp;
		if (list.get(cnt).type == 1) {
			// 상
			tmp = copyMap(map);
			monitorUp(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
			// 하
			tmp = copyMap(map);
			monitorDown(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
			// 좌
			tmp = copyMap(map);
			monitorLeft(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
			// 우
			tmp = copyMap(map);
			monitorRight(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
		}
		if (list.get(cnt).type == 2) {
			// 상,하
			tmp = copyMap(map);
			monitorUp(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorDown(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);

			// 좌,우
			tmp = copyMap(map);
			monitorLeft(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorRight(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
		}
		if (list.get(cnt).type == 3) {
			// 상, 좌
			tmp = copyMap(map);
			monitorUp(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorLeft(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
			// 좌, 하
			tmp = copyMap(map);
			monitorLeft(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorDown(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
			// 하, 우
			tmp = copyMap(map);
			monitorDown(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorRight(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
			// 우, 상
			tmp = copyMap(map);
			monitorRight(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorUp(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
		}
		if (list.get(cnt).type == 4) {
			// ㅗ방향
			tmp = copyMap(map);
			monitorUp(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorLeft(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorRight(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);

			// ㅏ방향
			tmp = copyMap(map);
			monitorUp(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorDown(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorRight(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);

			// ㅜ방향
			tmp = copyMap(map);
			monitorDown(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorLeft(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorRight(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);

			// ㅓ방향
			tmp = copyMap(map);
			monitorUp(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorDown(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorLeft(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
		}
		if (list.get(cnt).type == 5) {
			// 상,하,좌,우
			tmp = copyMap(map);
			monitorUp(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorDown(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorLeft(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			monitorRight(list.get(cnt).x, list.get(cnt).y, tmp); // 마킹
			dfs(cnt + 1, tmp);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6)
					list.add(new CCTV(i, j, map[i][j]));
			}
		}
		direction = new int[list.size()];
		dfs(0, map);
		System.out.println(result);

	}//

}//
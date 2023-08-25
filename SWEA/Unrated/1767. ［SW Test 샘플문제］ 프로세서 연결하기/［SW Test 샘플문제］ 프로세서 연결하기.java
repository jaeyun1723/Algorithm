import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static ArrayList<Point> list;
	static Point answer;

	static int[][] copy(int[][] original) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				tmp[i][j] = original[i][j];
		return tmp;
	}

	static void function(int idx, int core, int line, int[][] arr) {
		if (idx == list.size()) {
			if (answer.x < core) {
				answer.x = core;
				answer.y = line;
			}
			if (answer.x == core && answer.y > line)
				answer.y = line;
			return;
		}

		int[][] tmp;
		int length;
		// 1. 연결안하고 넘길 경우
		tmp = copy(arr);
		function(idx + 1, core, line, tmp);
		// 2. 위로 연결하기
		tmp = copy(arr);
		length = connectLine(list.get(idx).x, list.get(idx).y, 0, tmp);
		if (length != -1) // 위로 연결이 된다면
			function(idx + 1, core + 1, line + length, tmp);
		// 3. 아래로 연결하기
		tmp = copy(arr);
		length = connectLine(list.get(idx).x, list.get(idx).y, 1, tmp);
		if (length != -1) // 아래로 연결이 된다면
			function(idx + 1, core + 1, line + length, tmp);
		// 4. 왼쪽으로 연결하기
		tmp = copy(arr);
		length = connectLine(list.get(idx).x, list.get(idx).y, 2, tmp);
		if (length != -1) // 왼쪽으로 연결이 된다면
			function(idx + 1, core + 1, line + length, tmp);
		// 5. 오른쪽으로 연결하기
		tmp = copy(arr);
		length = connectLine(list.get(idx).x, list.get(idx).y, 3, tmp);
		if (length != -1) // 오른쪽으로 연결이 된다면
			function(idx + 1, core + 1, line + length, tmp);

	}

	static int connectLine(int r, int c, int direction, int[][] arr) {
		int x = r, y = c, cnt = 0;
		if (direction == 0) { // 위로
			while (--x >= 0)
				if (arr[x][y] != 0)
					return -1;
			for (int i = r - 1; i >= 0; i--) {
				cnt++;
				arr[i][c] = -1;
			}
		}
		if (direction == 1) { // 아래로
			while (++x < N)
				if (arr[x][y] != 0)
					return -1;
			for (int i = r + 1; i < N; i++) {
				cnt++;
				arr[i][c] = -1;
			}
		}
		if (direction == 2) { // 왼쪽
			while (--y >= 0)
				if (arr[x][y] != 0)
					return -1;
			for (int i = c - 1; i >= 0; i--) {
				cnt++;
				arr[r][i] = -1;
			}
		}
		if (direction == 3) { // 오른쪽
			while (++y < N)
				if (arr[x][y] != 0)
					return -1;
			for (int i = c + 1; i < N; i++) {
				cnt++;
				arr[r][i] = -1;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int[][] processor = new int[N][N];
			list = new ArrayList<>();
			int core = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					processor[i][j] = Integer.parseInt(st.nextToken());
					if (processor[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1)
							core++;
						else
							list.add(new Point(i, j));
					}
				}
			}
			answer = new Point(core, Integer.MAX_VALUE);
			function(0, core, 0, processor);
			System.out.println("#" + t + " " + answer.y);

		}

	}//

}//
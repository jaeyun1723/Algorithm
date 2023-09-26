import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[][] sudoku;
	static boolean flag;
	static ArrayList<int[]> list;

	static boolean isAvailable(int x, int y, int num) {
		for (int i = 0; i < 9; i++)
			if (sudoku[x][i] == num || sudoku[i][y] == num)
				return false;
		int r = 3 * (x / 3), c = 3 * (y / 3);
		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (sudoku[i][j] == num)
					return false;
		return true;
	}

	static void solution(int idx) {
		if (flag || idx == list.size()) {
			flag = true;
			return;
		}
		for (int k = 1; k <= 9; k++)
			if (isAvailable(list.get(idx)[0], list.get(idx)[1], k)) {
				sudoku[list.get(idx)[0]][list.get(idx)[1]] = k;
				solution(idx + 1);
				if (flag)
					return;
			}
		sudoku[list.get(idx)[0]][list.get(idx)[1]] = 0;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sudoku = new int[9][9];
		int cnt = 0;
		list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = str.charAt(j) - '0';
				if (sudoku[i][j] == 0)
					list.add(new int[] { i, j });
			}
		}
		solution(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(sudoku[i][j]);
			System.out.println();
		}

	}
}
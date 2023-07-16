import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] sudoku;

	static boolean width(int x, int y) {
		boolean[] flag = new boolean[10];
		for (int i = 0; i < sudoku.length; i++) {
			if (flag[sudoku[x][i]])
				return false;
			else
				flag[sudoku[x][i]] = true;
		}
		return true;
	}

	static boolean column(int x, int y) {
		boolean[] flag = new boolean[10];
		for (int i = 0; i < sudoku.length; i++) {
			if (flag[sudoku[i][y]])
				return false;
			else
				flag[sudoku[i][y]] = true;
		}
		return true;
	}

	static boolean square(int x, int y) {
		boolean[] flag = new boolean[10];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (flag[sudoku[x + i][y + j]]) {
					return false;
				} else
					flag[sudoku[x + i][y + j]] = true;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			sudoku = new int[9][9];
			boolean isAvailable = true;
			for (int j = 0; j < sudoku.length; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < sudoku[j].length; k++) {
					sudoku[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			for (int j = 0; j < sudoku.length; j++) {
				if (!isAvailable)
					break;
				if (!width(j, j) || !column(j, j)) {
					isAvailable = false;
					break;
				}
				if (j % 3 == 0)
					for (int k = 0; k < 9; k += 3)
						if (!square(j, k)) {
							isAvailable = false;
							break;
						}

			}
			if (isAvailable)
				System.out.println("#" + i + " " + 1);
			else
				System.out.println("#" + i + " " + 0);
		} // test_case
	}// main
}// class

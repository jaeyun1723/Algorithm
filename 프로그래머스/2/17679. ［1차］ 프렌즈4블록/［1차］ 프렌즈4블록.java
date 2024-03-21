import java.util.*;

class Solution {
	int M, N;
	int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	char[][] blocks;
	boolean[][] isBlocked;

	public void arrange(ArrayList<int[]> arrayList) {
		for (int i = 0; i < arrayList.size(); i++) {
			int x = arrayList.get(i)[0];
			int y = arrayList.get(i)[1];
			blocks[x][y] = '.';
			blocks[x + 1][y] = '.';
			blocks[x][y + 1] = '.';
			blocks[x + 1][y + 1] = '.';
			isBlocked[x][y] = true;
			isBlocked[x][y + 1] = true;
			isBlocked[x + 1][y] = true;
			isBlocked[x + 1][y + 1] = true;
		}
		for (int i = 0; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				if (blocks[j][i] == '.') {
					int k = j - 1;
					while (k >= 0 && blocks[k][i] == '.') {
						k--;
					}
					if (k >= 0) {
						blocks[j][i] = blocks[k][i];
						blocks[k][i] = '.';
					}
				}
			}
		}
	}

	public ArrayList<int[]> check() {
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < M - 1; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (blocks[i][j] != '.' && blocks[i][j] == blocks[i][j + 1] && blocks[i][j] == blocks[i + 1][j]
					&& blocks[i][j] == blocks[i + 1][j + 1]) {
					list.add(new int[] {i, j});
				}
			}
		}
		return list;
	}

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		blocks = new char[m][n];
		isBlocked = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			blocks[i] = board[i].toCharArray();
		}
		M = m;
		N = n;
		int r = 0;
		int c = 0;
		while (true) {
			ArrayList<int[]> list = check();
			if (list.isEmpty())
				break;
			arrange(list);
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (blocks[i][j]=='.')
					answer++;
			}
		}
		return answer;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr;
	static int answer;
	static boolean[][] isVisit;

	static void ladder(int x, int y) {
		isVisit[x][y] = true;
		if (x == 0) {
			answer = y;
			return;
		} else {
			if (y - 1 >= 0 && !isVisit[x][y - 1] && arr[x][y - 1] == 1)
				ladder(x, y - 1);
			else if (y + 1 < 100 && !isVisit[x][y + 1] && arr[x][y + 1] == 1)
				ladder(x, y + 1);
			else
				ladder(x - 1, y);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			arr = new int[100][100];
			isVisit = new boolean[100][100];
			int x = 0, y = 0;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}

			ladder(x, y);
			System.out.println("#" + t + " " + answer);
		} //

	}//

}//
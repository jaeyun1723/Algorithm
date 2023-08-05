import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.sql.rowset.CachedRowSet;

public class Solution {

	static int[][] arr;
	static int N, M;

	static int catchMax(int r, int c) {
		int sum = 0;
		for (int i = r; i < r + M; i++) {
			for (int j = c; j < c + M; j++) {
				if (i < 0 || i >= N || j < 0 || j >= N)
					continue;
				sum += arr[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			int answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					answer = Math.max(answer, catchMax(i, j));
				}
			}

			System.out.println("#" + t + " " + answer);
		}

	}//

}//